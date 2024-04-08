package codestartup.bookorder.controller;

import codestartup.bookorder.dto.BookOrderRequestDto;
import codestartup.bookorder.service.BookOrderService;
import codestartup.bookorder.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
class BookControllerTest {

    @InjectMocks
    BookController bookController;

    @Mock
    BookService bookService;

    @Mock
    BookOrderService bookOrderService;

    @Mock
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    @DisplayName("전체 도서 조회")
    public void findAllBookWithDiscount() throws Exception {
        // given

        // when, then
        mockMvc.perform(
                        get("/book/list"))
                .andExpect(status().isOk());

        verify(bookService).findAllBookWithDiscount();
    }

    @Test
    @DisplayName("도서 주문")
    public void bookOrder() throws Exception {
        String content = objectMapper.writeValueAsString(new BookOrderRequestDto(1, "CASH", 30000, 30000, 27000));

        mockMvc.perform(post("/book/order")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());

        verify(bookOrderService).bookOrderResponse(new BookOrderRequestDto(1, "CASH", 30000, 30000, 27000));
    }
}