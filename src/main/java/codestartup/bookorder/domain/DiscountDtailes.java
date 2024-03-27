package codestartup.bookorder.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 할인 내용
public class DiscountDtailes {
    private String discount_Day;
    private String discount_category;
    private int discount;

    public DiscountDtailes(String discount_Day, String discount_category, int discount) {
        this.discount_Day = discount_Day;
        this.discount_category = discount_category;
        this.discount = discount;
    }
}
