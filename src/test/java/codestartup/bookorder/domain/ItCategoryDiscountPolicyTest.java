package codestartup.bookorder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItCategoryDiscountPolicyTest {

    @Test
    void isDiscountable() {
        //given
        String category = "개발";
        boolean discountable = false;

        if(category.equals("개발"))
            discountable = true;

        // when
        boolean result = false;

        //then
        assertThat(discountable).isEqualTo(result);
    }

}