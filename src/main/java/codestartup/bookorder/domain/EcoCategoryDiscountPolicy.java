package codestartup.bookorder.domain;

public class EcoCategoryDiscountPolicy implements DiscountPolicy{

    private static final int DISCOUNT_PRICE = 1500;

    @Override
    public boolean isDiscountable(BookResponse book) {
        String category = book.getCategory();
        if(category.equals("교양")){
            return true;
        }
        return false;
    }


    public int getDiscount(BookResponse book) {
        return DISCOUNT_PRICE;
    }

}
