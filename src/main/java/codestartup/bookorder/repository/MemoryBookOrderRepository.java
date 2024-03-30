package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookOrderResponse;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemoryBookOrderRepository implements BookOrderRepository{

    @Override
    public BookOrderResponse bookOrder(BookResponse bookResponse, String pay_method, int id, int pay_amount) {
        BookOrderResponse resultList = new BookOrderResponse();
        resultList.setBookResponse(bookResponse);
        resultList.setPay_amount(pay_amount);
        resultList.setPay_method(pay_method);

        // 현금일 경우만 거스름돈 계산
        if(pay_method == "CASH"){
            int pay = 0;

            if(resultList.getBookResponse().getDiscountDetailes().getDiscount() != 0){
                pay = resultList.getBookResponse().getDiscountDetailes().getDiscount();
            }else{
                pay = resultList.getBookResponse().getOrigind_price();
            }

            resultList.setChange_amount(pay_amount - pay);
        }

        return resultList;
    }
}
