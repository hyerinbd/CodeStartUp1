package codestartup.bookorder.service;

import codestartup.bookorder.domain.*;
import codestartup.bookorder.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;
    private final DiscountPolicy discountPolicy;

    // TODO: 별도의 repo가 있는 걸로 변경
        private List<DiscountPolicy> discountPolicies = List.of(
                new ItCategoryDiscountPolicy(),
                new EcoCategoryDiscountPolicy()
        );

        public List<BookResponse> applyDiscountList(List<Book> books){
            //TODO: OCP open closed principle 공부해보기
            // 변경이 발생해도 기본 구조는 수정되지 않고
            // 다른 기능들도 쉽게 추가해서 사용 가능하도록
            /*for (Book book : books) {
                dateDiscount(book);
                //categoryDiscount();
            }*/

            List<BookResponse> bookResponseList = discountRepository.applyDiscountList(books);

            //TODO: 구현
            /*int sum = 0;
            for(DiscountPolicy discountPolicy : discountPolicies){
                if(discountPolicy.isDiscountable(book)){
                    int discount = discountPolicy.getDiscount(book);
                    sum += discount;
                }
            }
            book.setDiscountPrice(sum);*/

            for(BookResponse bookResponse : bookResponseList){
                for(DiscountPolicy discountPolicy : discountPolicies){
                    if(discountPolicy.isDiscountable(bookResponse) == true){

                        bookResponse.getDiscountDetailesList().stream().forEach(discountDtailes -> {
                            discountDtailes.setDiscount(bookResponse.getOrigind_price() - discountPolicy.getDiscount(bookResponse));
                        });
                    }else{
                        bookResponse.getDiscountDetailesList().stream().forEach(discountDtailes -> {
                            discountDtailes.setDiscount(0);
                        });
                    }

                }
            }

            return bookResponseList;
        }

        /*private void categoryDiscount(){
            // it = 1
            // 재테크 = 4
        }

        private void dateDiscount(Book book){
            LocalDate now = LocalDate.now();    // 현재 날짜
            int dayOfWeekValue = now.getDayOfWeek().getValue();
            System.out.println("dayOfWeekValue : " + dayOfWeekValue);
        }*/
}
