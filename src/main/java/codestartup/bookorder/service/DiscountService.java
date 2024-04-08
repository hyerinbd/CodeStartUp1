package codestartup.bookorder.service;

import codestartup.bookorder.domain.*;
import codestartup.bookorder.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;

    public List<BookResponse> applyDiscountList(Book book){

        List<DiscountPolicyV2> discountPolices = discountRepository.findAll();

        List<BookResponse> bookResponseList = new ArrayList<>();
        int discountPriceSum = 0;
        // TODO: OCP, open-closed principle
        for (DiscountPolicyV2 discountPolicyV2 : discountPolices) {
            if (discountPolicyV2.isDiscountable(book)) {
                discountPriceSum += discountPolicyV2.getDiscount(book);
            }
        }
        bookResponseList.add(new BookResponse(book, discountPriceSum));
        return bookResponseList;
    }
}
