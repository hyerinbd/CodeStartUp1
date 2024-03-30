package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import codestartup.bookorder.domain.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemoryBookRepository implements BookRepository{
    /*
    * sample book List
    * */
    private static Map<Integer, Book> bookStore = Map.of(
            1, new Book(1, "유지보수 어렵게 개발하는 방법", "개발", 30000),
            2, new Book(2, "기획자 비난 완벽 가이드", "교양", 12900),
            3, new Book(3, "Not 이펙티브 자바", "개발", 33000)
    );
    
    /*
    * 모든 도서 조회
    * */
    @Override
    public List<Book> bookListAll(){
        return new ArrayList<>(bookStore.values());
    }

    /*
    * id로 도서 조회
    * */
    @Override
    public BookResponse findBookById(List<BookResponse> book, int id) {
        BookResponse result = null;
        for(BookResponse resultBookList : book){
            if(id == resultBookList.getId()){
                result = resultBookList;
            }
        }
        return result;
    }

}
