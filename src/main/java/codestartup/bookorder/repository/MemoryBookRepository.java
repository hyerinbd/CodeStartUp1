package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryBookRepository implements BookRepository{

    private static Map<Long, Book> store = new HashMap<>();

    @Override
    public List<Book> bookListAll(){
        return new ArrayList<>(store.values());
    }  // 모든 도서 조회

    @Override
    public Optional<Book> findBookById(long id) {
        return Optional.empty();
    }
}
