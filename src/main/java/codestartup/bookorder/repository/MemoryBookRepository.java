package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.*;

@Repository
public class MemoryBookRepository implements BookRepository{

    private static Map<Long, Book> store = Map.of(
//            1L, new Book(1L, "스프링5 레시피", 20000, 10),
//            2L, new Book(2L, "JPA 프로그래밍", 30000, 20)
    );


    @Override
    public List<Book> bookListAll(){
        return new ArrayList<>(store.values());
    }  // 모든 도서 조회

    @Override
    public Optional<Book> findBookById(long id) {
        return Optional.empty();
    }
}
