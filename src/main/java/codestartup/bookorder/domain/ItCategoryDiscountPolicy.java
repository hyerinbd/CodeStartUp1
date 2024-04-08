package codestartup.bookorder.domain;

public class ItCategoryDiscountPolicy{

    private static final int DISCOUNT_PERCENT = 10;

    public DiscountPolicy isDiscountable(DiscountPolicy discountPolicy) {
        String category = discountPolicy.getCategory();

        if(category.equals("개발")){
            discountPolicy.setDiscountable(true);
        }
        return discountPolicy;
    }

    public int getDiscount(int price) {
        return price * (DISCOUNT_PERCENT/100);
    }

}
