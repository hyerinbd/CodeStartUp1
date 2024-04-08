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
            String category = books.get(i).getCategory();
            responseList.add(i
                    , new BookResponse(books.get(i).getId(), books.get(i).getName(), books.get(i).getCategory(), books.get(i).getPrice()
                            , new DiscountDtailes()));
        }

        return responseList;
    }
}
