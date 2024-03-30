package codestartup.bookorder.repository;

import codestartup.bookorder.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemoryDiscountRepository implements DiscountRepository {

    // TODO: 별도의 repo가 있는 걸로 변경
    private List<DiscountPolicy> discountPolicies = List.of(
            new ItCategoryDiscountPolicy(),
            new EcoCategoryDiscountPolicy()
    );

    public List<BookResponse> applyDiscountList(List<Book> books) {
        List<BookResponse> responseList = new ArrayList<>();
        for(int i=0;i<books.size();i++){
            String category = books.get(i).getCategory();
            responseList.add(i
                    , new BookResponse(books.get(i).getId(), books.get(i).getName(), books.get(i).getCategory(), books.get(i).getPrice()
                            , new DiscountDtailes(dateDiscount(category), categoryDiscount(category), 0)));
        }

        for(BookResponse bookResponse : responseList){
            for(DiscountPolicy discountPolicy : discountPolicies){
                if(discountPolicy.isDiscountable(bookResponse) == true){    // 할인 적용 여부
                    bookResponse.getDiscountDetailes().setDiscount(bookResponse.getOrigind_price() - discountPolicy.getDiscount(bookResponse)); // 할인금액 셋팅
                }else{
                    bookResponse.getDiscountDetailes().setDiscount(0);
                }
            }
        }

        return responseList;
    }

    /*@Override
    public boolean isDiscountable(Book book) {
        return false;
    }*/

    /*
     * 요일 할인 정책
     * */
    private String dateDiscount(String category) {
        String discountDay = "";

        LocalDate now = LocalDate.now();    // 현재 날짜
        int dayOfWeekValue = now.getDayOfWeek().getValue(); // 현재 요일

        if(dayOfWeekValue == 5 && category == "개발") {
            discountDay = "금요일";
        }else if(category == "교양"){
            discountDay = "매일";
        }
        return discountDay;
    }

    /*
     * 카테고리 할인 정책
     * */
    private String categoryDiscount(String category){
        String discountCategory = "";

        LocalDate now = LocalDate.now();    // 현재 날짜
        int dayOfWeekValue = now.getDayOfWeek().getValue(); // 현재 요일

        if(dayOfWeekValue == 5 && category == "개발") {
            discountCategory = "개발";
        }else if(category == "교양"){
            discountCategory = "교양";
        }

        return discountCategory;
    }
}
