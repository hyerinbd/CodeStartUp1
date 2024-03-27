package codestartup.bookorder.domain;

// TODO: 도메인 분리
public interface DiscountPolicy {
    boolean isDiscountable(BookResponse book);  // 할인가능여부

    int getDiscount(BookResponse book);
}
