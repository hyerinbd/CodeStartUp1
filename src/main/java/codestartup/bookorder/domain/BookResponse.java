package codestartup.bookorder.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {
    private int id;
    private String name;
    private String category;
    private int origind_price;
    private DiscountDtailes discountDetailes;

    public BookResponse(int id, String name, String category, int price, DiscountDtailes discountDetailes) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.origind_price = price;
        this.discountDetailes = discountDetailes;
    }
}