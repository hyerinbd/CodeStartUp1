package codestartup.bookorder.service;

import codestartup.bookorder.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final FridayDiscountPolicy fridayDiscountPolicy;
    private final ItCategoryDiscountPolicy itCategoryDiscountPolicy;
    private final EcoCategoryDiscountPolicy ecoCategoryDiscountPolicy;
    private final DiscountPolicy discountPolicy;

    public List<BookResponse> applyDiscountList(List<Book> books){

        List<BookResponse> bookResponseList = new ArrayList<>();
        for(int i=0;i<books.size();i++){
            bookResponseList.add(i,
                    new BookResponse(books.get(i).getId(), books.get(i).getName(), books.get(i).getCategory(), books.get(i).getPrice(),
                            new DiscountDtailes()));
        }

        //TODO: 구현
        for(int i=0;i<bookResponseList.size();i++){
            String category = bookResponseList.get(i).getCategory();
            int price = bookResponseList.get(i).getOrigind_price();

            int ordert_y = 2024;
            int ordert_m = 4;
            int ordert_d = 5;

            discountPolicy.setOrder_y(ordert_y);
            discountPolicy.setOrder_m(ordert_m);
            discountPolicy.setOrder_d(ordert_d);

            discountPolicy.setCategory(category);

            DiscountPolicy returnFridayPolicy = fridayDiscountPolicy.isDiscountable(discountPolicy);
            DiscountPolicy returnItPolicy = itCategoryDiscountPolicy.isDiscountable(discountPolicy);
            DiscountPolicy returnEcoPolicy = ecoCategoryDiscountPolicy.isDiscountable(discountPolicy);

            if(returnFridayPolicy.isDiscountable() && returnItPolicy.isDiscountable()) {
                bookResponseList.get(i).getDiscountDetailes().setDiscount_Day(returnFridayPolicy.getDiscount_day());
                bookResponseList.get(i).getDiscountDetailes().setDiscount_category(category);
                bookResponseList.get(i).getDiscountDetailes().setDiscount(itCategoryDiscountPolicy.getDiscount(price));
            }else if(returnEcoPolicy.isDiscountable()){
                bookResponseList.get(i).getDiscountDetailes().setDiscount_Day(returnEcoPolicy.getDiscount_day());
                bookResponseList.get(i).getDiscountDetailes().setDiscount_category(category);
                bookResponseList.get(i).getDiscountDetailes().setDiscount(ecoCategoryDiscountPolicy.getDiscount(price));
            }

        }

        return bookResponseList;
    }
}
