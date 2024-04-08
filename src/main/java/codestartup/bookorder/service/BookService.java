package codestartup.bookorder.service;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final DiscountService discountService;

    public List<BookResponse> findAllBookWithDiscount() {
        List<Book> books = bookRepository.bookListAll();
        return discountService.applyDiscountList(book);
    }
}
