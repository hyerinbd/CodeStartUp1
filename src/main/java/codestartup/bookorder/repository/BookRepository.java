package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> bookListAll();  // 모든 도서 조회
    Optional<Book> findBookById(long id);   // id로 도서 조회
}
