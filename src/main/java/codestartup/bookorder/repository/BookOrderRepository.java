package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookOrderResponse;
import codestartup.bookorder.domain.BookResponse;

import java.util.List;

public interface BookOrderRepository {
    BookOrderResponse bookOrder(BookResponse bookResponse, String pay_method, int id, int pay_amount);  // 도서 구매
}
