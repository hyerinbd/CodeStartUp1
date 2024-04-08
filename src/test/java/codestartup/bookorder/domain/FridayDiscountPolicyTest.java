package codestartup.bookorder.domain;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class FridayDiscountPolicyTest {
    @Test
    public void isDiscountable() {
        //given
        int ordert_y = 2024;
        int ordert_m = 4;
        int ordert_d = 5;
        String discount_Day = "";

        LocalDate date = LocalDate.of(ordert_y, ordert_m, ordert_d);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek.getValue() == 5) {
            discount_Day = "금요일";
        }

        // when
        String result = "금요일";

        // then
        assertThat(discount_Day).isEqualTo(result);
    }
}
