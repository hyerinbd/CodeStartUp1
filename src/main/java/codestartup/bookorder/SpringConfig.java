package codestartup.bookorder;

import codestartup.bookorder.repository.BookRepository;
import codestartup.bookorder.repository.JdbcTemplateBookRepository;
import codestartup.bookorder.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// TODO: bean 주입방법
//@Configuration
//public class SpringConfig {
//    private final DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Bean
//    public BookService bookService(){
//        return new BookService(bookRepository());
//    }
//
//    @Bean
//    public BookRepository bookRepository(){
//        return new JdbcTemplateBookRepository(dataSource);
//    }
//}
