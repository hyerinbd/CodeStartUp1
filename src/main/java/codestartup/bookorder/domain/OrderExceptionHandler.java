package codestartup.bookorder.domain;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionHandler {
    @ExceptionHandler({OrderException.class, QueryException.})
    public String handleOrderException(OrderException e) {
        return e.getMessage();
    }
}
