package codestartup.bookorder.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class BookOrderServiceTest {

    /*
     * 도서 주문
     * */
    @Test
    public void bookOrder() {
        // given
        String pay_method = "CASH";
        int origin_price =  30000;
        int discount_price = 0;
        int pay_amount = 50000;
        int change_amount = 0;

        // given
        int bookPrice = origin_price;
        if(discount_price != 0){
            bookPrice = discount_price;
        }

        // when
        int result = 20000;

        // then
        assertThat(pay_amount - bookPrice).isEqualTo(result);
    }

}
