package codestartup.bookorder.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookOrderResponse {
    private BookResponse bookResponse;
    private String pay_method;  // 지불 방법
    private int pay_amount; // 지불 금액
    private int change_amount; // 거스름돈
}