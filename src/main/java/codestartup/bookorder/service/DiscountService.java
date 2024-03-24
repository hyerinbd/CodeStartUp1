package codestartup.bookorder.service;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {

    // TODO: 별도의 repo가 있는 걸로 변경
        private List<DiscountPolicy> discountPolicies = List.of(
                new CategoryDiscountPolicy(),
                new DateDiscountPolicy()
        );

        public void applyDiscount(List<Book> books){

//            //TODO: OCP open closed principle 공부해보기
//            for (Book book : books) {
//                dateDiscount();
//                categoryDiscount();
//            }


            //TODO: 구현
            int sum = 0;
            for(DiscountPolicy discountPolicy : discountPolicies){
                if(discountPolicy.isDiscountable(book)){
                    int discount = discountPolicy.getDiscount(book);
                    sum += discount;
                }
            }
            book.setDiscountPrice(sum);
        }

        private void categoryDiscount(){
            // it = 1
            // 재테크 = 4
        }

        private void dateDiscount(){
            // 금요일 = 3
        }
}
