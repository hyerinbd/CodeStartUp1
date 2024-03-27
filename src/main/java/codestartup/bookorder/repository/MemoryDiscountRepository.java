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

    public List<BookResponse> applyDiscountList(List<Book> books) {
        List<BookResponse> responseList = new ArrayList<>();
        for(int i=0;i<books.size();i++){
            responseList.add(i
                    , new BookResponse(books.get(i).getId(), books.get(i).getName(), books.get(i).getCategory(), books.get(i).getPrice()
                            , new ArrayList<DiscountDtailes>()));
        }

        for(int i=0;i<responseList.size();i++){
            String category = responseList.get(i).getCategory();
            responseList.get(i).setDiscountDetailesList(Collections.singletonList(new DiscountDtailes(dateDiscount(category), categoryDiscount(category), 0)));
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
