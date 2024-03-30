package codestartup.bookorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"codestartup.bookorder.domain.DiscountPolicy"})
public class BookorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookorderApplication.class, args);
	}

}
