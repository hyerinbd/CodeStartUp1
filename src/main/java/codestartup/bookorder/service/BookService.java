package codestartup.bookorder.service;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// TODO: 스프링에서 bean 주입방법에 대해 알아보기
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final DiscountService discountService;

    public List<BookResponse> findAllBookWithDiscount() {
        // 전체 도서 조회
        List<Book> books = bookRepository.bookListAll();
        // 할인 정보 포람 조회
        List<BookResponse> resultList = discountService.applyDiscountList(books);
        return resultList;
    }

    /*
    * id로 도서 조회
    * */
    public BookResponse findBookListById(List<BookResponse> book, int id) {
        BookResponse resultList = bookRepository.findBookById(book, id);
        return resultList;
    }
}
