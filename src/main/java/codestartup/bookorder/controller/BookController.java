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
    * 도서주문
    * */
    @PostMapping("/book/order")
    public BookOrderResponseDto bookOrder(
            // TODO: request DTO로 변경
            //  변경
            //  검증 등
            // TODO:  @RequestBody 사용해보기
            @Validated @RequestBody BookOrderRequestDto request
    ) throws Exception {
        try {
            // 생성자 or 함수
            new BookOrderRequestDto(request.getId(), request.getPay_method(), request.getPay_amount(), request.getOrigin_price(), request.getDiscount_price());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        BookOrderResponseDto response = bookOrderService.bookOrderResponse(request);
        return ResponseEntity.ok(response).getBody();
    }
}
