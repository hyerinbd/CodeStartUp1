package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookOrderResponse;
import codestartup.bookorder.domain.BookResponse;
import codestartup.bookorder.domain.DiscountDtailes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class MemoryBookOrderRepositoryTest {
    MemoryBookOrderRepository repository = new MemoryBookOrderRepository();

    private static BookResponse bookStore =
            new BookResponse(1, "유지보수 어렵게 개발하는 방법", "개발", 30000, new DiscountDtailes("", "", 0));
    //new BookResponse(2, "기획자 비난 완벽 가이드", "교양", 12900, new DiscountDtailes("", "", 0));
    //new BookResponse(3, "Not 이펙티브 자바", "개발", 33000, new DiscountDtailes("", "", 0));

    @BeforeEach
    public void init() {
        // db
        // talbe
    }

    @AfterEach
    public void clear() {
        // db
        // table
    }
    /*
     * 도서 주문
     * */
    @Test
    public void bookOrder() {
        // given
        BookOrderResponse resultList = new BookOrderResponse();
        String pay_method = "CASH";
        int pay_amount = 30000;
        resultList.setBookResponse(bookStore);
        resultList.setPay_amount(pay_amount);
        resultList.setPay_method(pay_method);

        // when
//        if(pay_method == "CASH"){
//            int pay = 0;
//
//            if(resultList.getBookResponse().getDiscountDetailes().getDiscount() != 0){
//                pay = resultList.getBookResponse().getDiscountDetailes().getDiscount();
//            }else{
//                pay = resultList.getBookResponse().getOrigind_price();
//            }
//
//            resultList.setChange_amount(pay_amount - pay);
//        }
        // given
        int bookPrice = 2000;
        int discountPrice = 1000;

        // when
        int result = 500;

        // then
        // import static org.assertj.core.api.Assertions.assertThat;
        assertThat(bookPrice - discountPrice).isEqualTo(result);
    }

}
