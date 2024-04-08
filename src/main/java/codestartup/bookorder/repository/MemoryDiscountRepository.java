package codestartup.bookorder.repository;

import codestartup.bookorder.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemoryDiscountRepository implements DiscountRepository {


    @Override
    public List<DiscountPolicyV2> findAll() {
//        sort
        return List.of(
                new AnialCategoryDiscountPolicyV2(),
        new FridayItDiscountPolicyV2()
        );
    }
}
