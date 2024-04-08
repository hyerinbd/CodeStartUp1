package codestartup.bookorder.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;

// TODO: 구현
public class FridayDiscountPolicy{

    public DiscountPolicy isDiscountable(DiscountPolicy discountPolicy) {
        String day = "";
        LocalDate date = LocalDate.of(discountPolicy.getOrder_y(), discountPolicy.getOrder_m(), discountPolicy.getOrder_d());
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek.getValue() == 5) {
            discountPolicy.setDiscountable(true);
            discountPolicy.setDiscount_day("금요일");
        }
        return discountPolicy;
    }
}
