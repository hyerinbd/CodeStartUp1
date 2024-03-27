package codestartup.bookorder.repository;

import codestartup.bookorder.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateBookRepository implements BookRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateBookRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Book> bookListAll() {
        // TODO: 3layer에서 뭐가 잘못된걸까?
        // 책임이 persist로 가버림
        // DB 부하걸려요
        return jdbcTemplate.query(
                "select\n" +
                        "  id\n" +
                        ", name\n" +
                        ", category\n" +
                        ", price as origin_price\n" +
                        ", CONVERT(case when category = '교양' then price - 1500\n" +
                        "           when category = '개발' and DAY_OF_WEEK(now()) = '6' then price - (price * 0.1)\n" +
                        "  else 0 \n" +
                        "end , INT) as discount_price\n" +
                        "from book", bookrRowMapper());
    }

    /*@Override
    public Optional<Book> findBookById(long id) {
        List<Book> result = jdbcTemplate.query(
                "select\n" +
                        "  id\n" +
                        ", name\n" +
                        ", category\n" +
                        ", price as origin_price\n" +
                        ", CONVERT(case when category = '교양' then price - 1500\n" +
                        "           when category = '개발' and DAY_OF_WEEK(now()) = '6' then price - (price * 0.1)\n" +
                        "  else 0 \n" +
                        "end , INT) as discount_price\n" +
                        "from book where id = ?", bookrRowMapper(), id);
        return result.stream().findAny();
    }*/

    private RowMapper<Book> bookrRowMapper(){
        return (rs, rowNum) -> {
            Book book = new Book();
            book.setId((int) rs.getLong("id"));
            book.setName(rs.getString("name"));
            book.setCategory(rs.getString("category"));
            //book.setOrigin_price(rs.getInt("origin_price"));
            //book.setDiscount_price(rs.getInt("discount_price"));
            return book;
        };
    }
}
