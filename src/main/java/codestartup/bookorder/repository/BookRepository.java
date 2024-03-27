package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookResponse;

import java.util.List;

public interface BookRepository {
    List<Book> bookListAll();  // 모든 도서 조회
    //List<BookResponse> findAllBookWithDiscount();   //
    /*Optional<Book> findBookById(long id);   // id로 도서 조회*/
}
