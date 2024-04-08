package codestartup.bookorder.controller;

import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.dto.BookOrderRequestDto;
import codestartup.bookorder.dto.BookOrderResponseDto;
import codestartup.bookorder.service.BookOrderService;
import codestartup.bookorder.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
    * 도서주문
    * */
    @PostMapping("/book/order")
    public BookOrderResponseDto bookOrder(
            @Validated @RequestBody BookOrderRequestDto request
    ) {
//        try {
//            // 생성자 or 함수
////            request.validate();
//            new BookOrderRequestDto(request.getId(), request.getPay_method(), request.getPay_amount(), request.getOrigin_price(), request.getDiscount_price());
//        } catch (Exception e) {
//            // TODO: 검증
//            // TODO: ExceptionHandler 사용해보기, Spring에서 어떻게 예외를 처리하는 지.. 여러 방법이 있는데 장단
//            return ResponseEntity.badRequest(response).getBody();
//        }
        new BookOrderRequestDto(request.getId(), request.getPay_method(), request.getPay_amount(), request.getOrigin_price(), request.getDiscount_price());

        BookOrderResponseDto response = bookOrderService.bookOrderResponse(request);
        return ResponseEntity.ok(response).getBody();
    }
}
