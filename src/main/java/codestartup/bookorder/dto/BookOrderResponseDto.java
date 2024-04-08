package codestartup.bookorder.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookOrderResponseDto {

    private String pay_method;  // 지불 방법
    private int pay_amount; // 지불 금액
    private int origin_price; // 정가
    private int discount_price; // 할인 금액
    private int change_amount; // 거스름돈

    public BookOrderResponseDto(String pay_method, int pay_amount, int origin_price, int discount_price) throws Exception {
        this.pay_method = pay_method;
        this.pay_amount = pay_amount;
        this.origin_price = origin_price;
        this.discount_price = discount_price;
    }
}