package codestartup.bookorder.domain;

import java.time.LocalDate;

public class ItCategoryDiscountPolicy implements DiscountPolicy{

    private static final int DISCOUNT_PERCENT = 10;

    @Override
    public boolean isDiscountable(BookResponse book) {
        String category = book.getCategory();
        String discountDay = "";

        LocalDate now = LocalDate.now();    // 현재 날짜
        int dayOfWeekValue = now.getDayOfWeek().getValue(); // 현재 요일

        if(category.equals("개발") && dayOfWeekValue == 5){
            return true;
        }
        return false;
    }

    @Override
    public int getDiscount(BookResponse book) {
        return book.getOrigind_price() * (DISCOUNT_PERCENT/100);
    }
}
