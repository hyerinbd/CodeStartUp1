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
    private int discount_price;

    public BookResponse(Book book, int discount_price) {
        this.id = book.getId();
        this.name = book.getName();
        this.category = book.getCategory();
        this.origind_price = book.getPrice();
        this.discount_price = discount_price;
    }
}