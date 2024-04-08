package codestartup.bookorder.domain;

public interface DiscountPolicyV2 {
    boolean isDiscountable(Book book);
    int getDiscount(Book book);
}
