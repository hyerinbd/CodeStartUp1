package codestartup.bookorder.domain;

import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;

@RequiredArgsConstructor
public class FridayItDiscountPolicyV2 implements DiscountPolicyV2{

    private final Clock clock;

    public FridayItDiscountPolicyV2() {
        this.clock = Clock.systemDefaultZone();
    }

    @Override
    public boolean isDiscountable(Book book) {
        if(LocalDate.now(clock).getDayOfWeek() == DayOfWeek.FRIDAY && book.getCategory().equals("IT")){
            return true;
        }
        return false;
    }

    @Override
    public int getDiscount(Book book) {
        return 1000;
    }
}
