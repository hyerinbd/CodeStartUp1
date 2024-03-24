package codestartup.bookorder.service;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// TODO: 스프링에서 bean 주입방법에 대해 알아보기
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
//    private final DiscountService discountService;

    public List<BookResponse> findAllBookWithDisount(){

        // load book
        List<Book> books = bookRepository.bookListAll();

        // discount
//        discountService.applyDiscount(List<Book>)

        return null;
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
