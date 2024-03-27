package codestartup.bookorder.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BookResponse {
    //private List<Book> bookList;
    private int id;
    private String name;
    private String category;
    private int origind_price;
    private List<DiscountDtailes> discountDetailesList;

    public BookResponse(int id, String name, String category, int price, List<DiscountDtailes> discountDetailesList) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.origind_price = price;
        this.discountDetailesList = discountDetailesList;
    }
}