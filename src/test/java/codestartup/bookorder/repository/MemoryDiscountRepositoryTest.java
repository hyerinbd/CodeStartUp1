package codestartup.bookorder.repository;

import codestartup.bookorder.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class MemoryDiscountRepositoryTest {
    MemoryDiscountRepository repository = new MemoryDiscountRepository();
    private List<DiscountPolicy> discountPolicyList = List.of(
            new ItCategoryDiscountPolicy(),
            new EcoCategoryDiscountPolicy()
    );

   private static Map<Integer, Book> bookStore = Map.of(
           1, new Book(1, "유지보수 어렵게 개발하는 방법", "개발", 30000),
           2, new Book(2, "기획자 비난 완벽 가이드", "교양", 12900),
           3, new Book(3, "Not 이펙티브 자바", "개발", 33000)
   );

    @Test
    public void applyDiscountList() {
        List<BookResponse> responseList = new ArrayList<>();
        List<Book> bookList = new ArrayList<>(bookStore.values());
        for(int i=0;i<bookList.size();i++){
            responseList.add(i
                        , new BookResponse(bookList.get(i).getId(), bookList.get(i).getName(), bookList.get(i).getCategory(), bookList.get(i).getPrice()
                            , new ArrayList<DiscountDtailes>()));
        }

        for(int i=0;i<responseList.size();i++){
            String category = responseList.get(i).getCategory();
            responseList.get(i).setDiscountDetailesList(Collections.singletonList(new DiscountDtailes(dateDiscount(category), categoryDiscount(category), 0)));
        }

        for(BookResponse bookResponse : responseList){
            for(DiscountPolicy discountPolicy1 : discountPolicyList){
                if(discountPolicy1.isDiscountable(bookResponse) == true){

                    bookResponse.getDiscountDetailesList().stream().forEach(discountDtailes -> {
                        discountDtailes.setDiscount(bookResponse.getOrigind_price() - discountPolicy1.getDiscount(bookResponse));
                    });
                }else{
                    bookResponse.getDiscountDetailesList().stream().forEach(discountDtailes -> {
                        discountDtailes.setDiscount(0);
                    });
                }

            }
        }
    }

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
