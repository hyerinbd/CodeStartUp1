package codestartup.bookorder.controller;

import codestartup.bookorder.domain.BookOrderRequest;
import codestartup.bookorder.domain.BookOrderResponse;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.service.BookOrderService;
import codestartup.bookorder.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


//TODO: 화면 없이 rest api로 변경
@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;
    private final BookOrderService bookOrderService;

    /*
    * 도서주문 전체 목록
    * */
    @GetMapping("/book/list")
    public ResponseEntity<List<BookResponse>> findAllBookWithDiscount(){
        List<BookResponse> result = bookService.findAllBookWithDiscount();
        return ResponseEntity.ok(result);
    }

    /*
    * 도서주문 상세 목록
    * */
    @GetMapping("/book/order/{id}")
    public BookResponse bookOrderList(@RequestParam final int id){
        // TODO: controller 재사용하려고 하면 안됨
        //  책임
        //  controller가 너무 많은 걸 알게됨
//        BookResponse result = bookService.findBookWithDiscount(id);
        List<BookResponse> bookList = (List<BookResponse>) findAllBookWithDiscount();
        BookResponse result = bookService.findBookListById(bookList, id);
        return ResponseEntity.ok(result).getBody();
    }

    /*
    * 도서주문
    * */
    @PostMapping("/book/order")
    public BookOrderResponse bookOrder(
            // TODO: request DTO로 변경
            //  변경
            //  검증 등
            // TODO:  @RequestBody 사용해보기
//            @RequestBody BookOrderRequest request,
            @RequestParam BookResponse bookResponse, String pay_method, Long id, double pay_amount
    ){
        // 생성자 or 함수
//        request.validate();

        // 결제방식, id 필수
        if((pay_method == "" || pay_method == null) || id == 0){
            return (BookOrderResponse) ResponseEntity.badRequest();
        }

        // 결제방식 현금일 경우 필수
        if(pay_method == "CASH" && pay_amount == 0){
            return (BookOrderResponse) ResponseEntity.badRequest();
        }

        BookOrderResponse result = bookOrderService.bookOrderResponse(request);
        return ResponseEntity.ok(result).getBody();
    }
}
