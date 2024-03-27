package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.domain.DiscountDtailes;

import java.util.List;

public interface DiscountRepository {
    List<BookResponse> applyDiscountList(List<Book> book);

    //boolean isDiscountable(Book book);  // 할인가능여부
}
