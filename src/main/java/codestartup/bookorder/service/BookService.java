package codestartup.bookorder.service;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /*
   * 전체 도서 조회
   * */
    public List<Book> bookListAll(){
        return bookRepository.bookListAll();
    }

    /*
     * 도서 주문 상세 화면
     * */
    public Optional<Book> findBookById(long id){
        return bookRepository.findBookById(id);
    }
}
