package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookOrderResponse;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.domain.DiscountDtailes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemoryBookOrderRepositoryTest {
    MemoryBookOrderRepository repository = new MemoryBookOrderRepository();

    private static BookResponse bookStore =
            new BookResponse(1, "유지보수 어렵게 개발하는 방법", "개발", 30000, new DiscountDtailes("", "", 0));
            //new BookResponse(2, "기획자 비난 완벽 가이드", "교양", 12900, new DiscountDtailes("", "", 0));
            //new BookResponse(3, "Not 이펙티브 자바", "개발", 33000, new DiscountDtailes("", "", 0));

    /*
     * 도서 주문
     * */
    @Test
    public void bookOrder() {
        BookOrderResponse resultList = new BookOrderResponse();
        String pay_method = "CASH";
        int pay_amount = 30000;
        resultList.setBookResponse(bookStore);
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
    }

}
