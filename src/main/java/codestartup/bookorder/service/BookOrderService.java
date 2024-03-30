package codestartup.bookorder.service;

import codestartup.bookorder.domain.BookOrderResponse;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.repository.BookOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: 스프링에서 bean 주입방법에 대해 알아보기
@Service
@RequiredArgsConstructor
public class BookOrderService {
    private final BookOrderRepository bookOrderRepository;

    public BookOrderResponse bookOrderResponse(BookResponse bookResponse, String pay_method, int id, int pay_amount) {
        BookOrderResponse resultList = bookOrderRepository.bookOrder(bookResponse, pay_method, id, pay_amount);
        return resultList;
    }
}
