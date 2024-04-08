package codestartup.bookorder.domain;

public class EcoCategoryDiscountPolicy{

    private static final int DISCOUNT_PRICE = 1500;

    public DiscountPolicy isDiscountable(DiscountPolicy discountPolicy) {
        String category = discountPolicy.getCategory();

        if(category.equals("교양")){
            discountPolicy.setDiscountable(true);
        }
        return discountPolicy;
    }

    public int getDiscount(int price) {
        return price - DISCOUNT_PRICE;
    }

}
