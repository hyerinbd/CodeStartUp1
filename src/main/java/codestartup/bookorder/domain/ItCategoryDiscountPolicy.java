package codestartup.bookorder.domain;

public class ItCategoryDiscountPolicy implements DiscountPolicy{

    private static final int DISCOUNT_PERCENT = 10;

    @Override
    public boolean isDiscountable(Book book) {
        String category = book.getCategory();
        if(category.equals("it") || category.equals("재테크")){
            return true;
        }
        return false;
    }

    @Override
    public int getDiscount(Book book) {
        return book.getOrigin_price() * DISCOUNT_PERCENT;
    }
}