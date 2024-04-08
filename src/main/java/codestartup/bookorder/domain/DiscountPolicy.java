package codestartup.bookorder.domain;

import lombok.Getter;
import lombok.Setter;

// TODO: 도메인 분리
@Getter
@Setter
public class DiscountPolicy {

    private boolean isDiscountable; //  할인가능 여부
    private String category;    // 카테고리
    private int order_y;    // 주문 년
    private int order_m;    // 주문 월
    private int order_d;    // 주문 일
    private int discount_price; // 할인 금액
    private String discount_day; // 할인 요일

    public DiscountPolicy(DiscountPolicy discountable) {
        this.isDiscountable = discountable.isDiscountable();
        this.category = discountable.getCategory();
        this.order_y = discountable.getOrder_y();
        this.order_m = discountable.getOrder_m();
        this.order_d = discountable.getOrder_d();
        this.discount_price = discountable.getDiscount_price();
        this.discount_day = discountable.getDiscount_day();
    }

    public DiscountPolicy(boolean b, String category, int ordertY, int ordertM, int ordertD, int i, String s) {
        this.isDiscountable = b;
        this.category = category;
        this.order_y = ordertY;
        this.order_m = ordertM;
        this.order_d = ordertD;
        this.discount_price = i;
        this.discount_day = s;
    }
}
