package codestartup.bookorder.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Validated
public class BookQueryRequest {
    private int id;
    private String name;

}