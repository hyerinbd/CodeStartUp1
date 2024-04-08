package codestartup.bookorder.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookOrderRequestDto {
    private int id;
    private String pay_method;  // 지불 방법
    private int pay_amount; // 지불 금액
    private int origin_price; // 정가
    private int discount_price; // 할인 금액

    // TODO: 생성자 검증
    //  Lottto 1~45
    //  0번 로또가 생성이 애초에 안되어야하는게 아니냐?
    //  0번 생성하고 검증하는게 이상하지않냐?
    public BookOrderRequestDto(int id, String pay_method, int pay_amount, int origin_price, int discount_price) throws Exception {
        if(id == 0){
            throw new Exception("id는 필수값 입니다.");
        } else if (pay_method == null || pay_method == "") {
            throw new Exception("지불 방법은 필수입니다.");
        } else if (pay_method == "CASH") {
            int pay = origin_price;;
            if(discount_price != 0){
                pay = discount_price;
            }
            
            if(pay_amount == 0){
                throw new Exception("지불 금액은 필수입니다.");
            } else if (pay > pay_amount) {
                throw new Exception("지불 금액이 부족합니다.");
            }
        }
        this.id = id;
        this.pay_method = pay_method;
        this.pay_amount = pay_amount;
        this.origin_price = origin_price;
        this.discount_price = discount_price;
    }
}