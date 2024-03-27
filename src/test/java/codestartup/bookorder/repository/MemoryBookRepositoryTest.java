package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemoryBookRepositoryTest {
    MemoryBookRepository repository = new MemoryBookRepository();

    private static Map<Integer, Book> bookStore = Map.of(
            1, new Book(1, "유지보수 어렵게 개발하는 방법", "개발", 30000),
            2, new Book(2, "기획자 비난 완벽 가이드", "교양", 12900),
            3, new Book(3, "Not 이펙티브 자바", "개발", 33000)
    );

    /*
     * 모든 도서 조회
     * */
    @Test
    public void bookListAll(){
        List<Book> bookList =  new ArrayList<>(bookStore.values());
        
        for(int i=0;i<bookList.size();i++){
            System.out.println(i + "번째");
            System.out.println("id : " + bookList.get(i).getId());
            System.out.println("name : " + bookList.get(i).getName());
            System.out.println("category : " + bookList.get(i).getCategory());
            System.out.println("price : " + bookList.get(i).getPrice());
        }
    }

}
