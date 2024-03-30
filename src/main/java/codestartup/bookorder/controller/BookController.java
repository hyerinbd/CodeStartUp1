package codestartup.bookorder.controller;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookOrderResponse;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.service.BookOrderService;
import codestartup.bookorder.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


//TODO: 화면 없이 rest api로 변경
//@Controller
@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;
    private final BookOrderService bookOrderService;

    /*
    * 도서주문 전체 목록
    * */
    @GetMapping("/book/findAllBookWithDiscountList")
    public ResponseEntity<List<BookResponse>> findAllBookWithDiscount(){
        List<BookResponse> result = bookService.findAllBookWithDiscount();
        return ResponseEntity.ok(result);
    }

    /*@PostMapping("/book/bookOrder")
    public String bookOrder(@ModelAttribute Book book, Model model, BindingResult bindingResult) {

        // result = orderService.order(request);

        // TODO: 3layer 아키텍처를 왜 사용하는지? 공부
        // 다른 계층의 역할을 침범하지 않는다.
        // 각 컴포넌트의 역할이 명확해지므로 코드의 가독성과 기능 구현에 유리하고, 확장성이 좋아진다.
        // 각 계층이 독립적으로 작성되기 때문에 다른 레이어와의 의존성을 낮춰 단위테스트에 유리하다.
        // TODO: controller에 비즈니스 로직이 포함됨. 이를 service로 분리해야함
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

            // TODO: 책임 할당 제대로 안된것, 묻지 말고 시켜라
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
    }*/

    /*
    * 도서주문 상세 목록
    * */
    @GetMapping("/book/bookOrderList")
    public BookResponse bookOrderList(@RequestParam final int id){
        List<BookResponse> bookList = (List<BookResponse>) findAllBookWithDiscount();
        BookResponse result = bookService.findBookListById(bookList, id);
        return ResponseEntity.ok(result).getBody();
    }

    /*
    * 도서주문
    * */
    @PostMapping("/book/bookOrder")
    public BookOrderResponse bookOrder(@RequestParam BookResponse bookResponse, String pay_method, int id, int pay_amount){

        // 결제방식, id 필수
        if((pay_method == "" || pay_method == null) || id == 0){
            return (BookOrderResponse) ResponseEntity.badRequest();
        }

        // 결제방식 현금일 경우 필수
        if(pay_method == "CASH" && pay_amount == 0){
            return (BookOrderResponse) ResponseEntity.badRequest();
        }

        BookOrderResponse result = bookOrderService.bookOrderResponse(bookResponse, pay_method, id, pay_amount);
        return ResponseEntity.ok(result).getBody();
    }
}
