package codestartup.bookorder.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
public class BookOrderRequest {
    private int id;
    private String name;
    private String category;
    private int origind_price;
    private DiscountDtailes discountDetailes;

    // TODO: 생성자 검증
    //  Lottto 1~45
    //  0번 로또가 생성이 애초에 안되어야하는게 아니냐?
    //  0번 생성하고 검증하는게 이상하지않냐?
    public BookOrderRequest(int id, String name, String category, int price, DiscountDtailes discountDetailes) {
        if(id < 0){
            throw new IllegalArgumentException("id는 0보다 커야합니다.");
        }
        this.id = id;
        this.name = name;
        this.category = category;
        this.origind_price = price;
        this.discountDetailes = discountDetailes;
    }
}