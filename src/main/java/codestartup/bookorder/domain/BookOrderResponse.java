package codestartup.bookorder.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class BookOrderResponse {
    private BookResponse bookResponse;
    private String pay_method;  // 지불 방법
    private int pay_amount; // 지불 금액
    private int change_amount; // 거스름돈

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookOrderResponse that = (BookOrderResponse) o;
        return pay_amount == that.pay_amount && change_amount == that.change_amount && Objects.equals(bookResponse, that.bookResponse) && Objects.equals(pay_method, that.pay_method);
    }

    @Override
    public int hashCode() {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return Objects.hash(bookResponse, pay_method, pay_amount, change_amount);
    }
}