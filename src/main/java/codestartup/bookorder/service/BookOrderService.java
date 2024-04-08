package codestartup.bookorder.service;

import codestartup.bookorder.dto.BookOrderRequestDto;
import codestartup.bookorder.dto.BookOrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookOrderService {
    final BookOrderResponseDto bookOrderResponseDto;

    public BookOrderResponseDto bookOrderResponse(BookOrderRequestDto request) {

        String pay_method = request.getPay_method();
        int origin_price =  request.getOrigin_price();
        int discount_price = request.getDiscount_price();
        int pay_amount = request.getPay_amount();
        int pay = 0;

        bookOrderResponseDto.setPay_method(pay_method);
        bookOrderResponseDto.setOrigin_price(origin_price);
        bookOrderResponseDto.setDiscount_price(discount_price);
        bookOrderResponseDto.setPay_amount(pay_amount);

        // 현금일 경우만 거스름돈 계산
        if(pay_method == "CASH"){

            if(discount_price != 0){
                pay = discount_price;
            }else{
                pay = origin_price;
            }

            bookOrderResponseDto.setChange_amount(pay_amount - pay);
        }

        return bookOrderResponseDto;
    }
}
