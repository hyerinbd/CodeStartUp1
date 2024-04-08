package codestartup.bookorder.repository;

import codestartup.bookorder.domain.*;

import java.util.List;

public interface DiscountRepository {

    List<DiscountPolicyV2> findAll();

    //boolean isDiscountable(Book book);  // 할인가능여부
}
