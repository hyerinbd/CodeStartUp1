package codestartup.bookorder.service;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: 스프링에서 bean 주입방법에 대해 알아보기
// 어노테이션 등록방식(컴포넌트 스캔) : @Component 어노테이션
// 클래스를 생성하고 @Configuration 과 @Bean을 사용하여 직접 자바로 등록
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
}
