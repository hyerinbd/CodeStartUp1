package codestartup.bookorder.domain;

// TODO: 도메인 분리
public interface DiscountPolicy {
    boolean isDiscountable(Book book);

    int getDiscount(Book book);
}
