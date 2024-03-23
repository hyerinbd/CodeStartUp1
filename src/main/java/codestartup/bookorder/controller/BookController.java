package codestartup.bookorder.controller;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String bookListAll(Model model){
        List<Book> bookListAll = bookService.bookListAll();
        model.addAttribute("book", bookListAll);
        return "book/bookList";
    }

    @GetMapping("/book/bookOrderView")
    public String bookList(@RequestParam final Long id, Model model){
        Optional<Book> result = bookService.findBookById(id);
        Book book = result.get();
        model.addAttribute("book", book);
        return "book/bookOrderView";
    }

    @PostMapping("/book/bookOrder")
    public String bookOrder(@ModelAttribute Book book, Model model, BindingResult bindingResult) {

        // 필수값 체크
        // 1. 결제방식 체크 여부
        if(book.getPay_method() == null){
            bindingResult.addError(new FieldError("book", "pay_method", "결제 방식은 필수 입니다."));
            return "book/bookOrderView";
        }

        // 3. 현금일 경우 지불 금액은 필수이며 지불금액이 가격보다 적을 수 없다.
        if(book.getPay_method() == false){
            if(book.getPay_amount() == 0){
                bindingResult.addError(new FieldError("book", "pay_amount", "지불금액은 필수 입니다."));
                return "book/bookOrderView";
            }
            
            if(book.getDiscount_price() != 0){  // 할인금액이 존재하는 경우
                if(book.getPay_amount() < book.getDiscount_price()){
                    bindingResult.addError(new FieldError("book", "pay_amount", "지불금액이 적습니다."));
                    return "book/bookOrderView";
                }
            }else{
                if(book.getPay_amount() < book.getOrigin_price()){
                    bindingResult.addError(new FieldError("book", "pay_amount", "지불금액이 적습니다."));
                    return "book/bookOrderView";
                }
            }
        }

        System.out.println("book.getPay_method() : " + book.getPay_method());

        if(book.getPay_method() == false){ // 지불 금액이 현금일 경우
            if(book.getDiscount_price() != 0){  // 할인금액이 존재하는 경우
                book.setChange_amount(book.getPay_amount() - book.getDiscount_price()); // 지불 금액 - 할인 금액
            }else{
                book.setChange_amount(book.getPay_amount() - book.getOrigin_price());   // 지불 금액 - 원래 금액
            }
        }
        model.addAttribute("book", book);
        return "book/bookOrderView";
    }
}
