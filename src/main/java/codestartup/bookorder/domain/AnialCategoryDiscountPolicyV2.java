package codestartup.bookorder.domain;

public class AnialCategoryDiscountPolicyV2 implements DiscountPolicyV2{

    private final float DISCOUNT_PERCENT = 0.1F;

    @Override
    public boolean isDiscountable(Book book) {
        if(book.getCategory().equals("IT")){
            return true;
        }
        return false;
    }

    @Override
    public int getDiscount(Book book) {
        return (int) (book.getPrice() * DISCOUNT_PERCENT);
    }
}
