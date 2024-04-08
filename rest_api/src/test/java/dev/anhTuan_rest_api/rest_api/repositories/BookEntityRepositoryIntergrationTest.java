package dev.anhTuan_rest_api.rest_api.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.anhTuan_rest_api.rest_api.TestDataUtil;
import dev.anhTuan_rest_api.rest_api.domain.dto.BookDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class BookEntityRepositoryIntergrationTest {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @Autowired
    public void setMockMvc(MockMvc mockMvc,ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.mockMvc = mockMvc;
    }
    @Test
    public void testThatCreatBookReturnHttpStatus201Created() throws Exception {
        BookDTO bookDTO  = TestDataUtil.createTestBookDtoA(null);
       String createbookJson = objectMapper.writeValueAsString(bookDTO);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/"+bookDTO.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createbookJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }
    @Test
    public void testThatCreatBookReturnHttpReturnCreateBook() throws Exception {
        BookDTO bookDTO  = TestDataUtil.createTestBookDtoA(null);
        String createbookJson = objectMapper.writeValueAsString(bookDTO);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/"+bookDTO.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createbookJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(bookDTO.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value(bookDTO.getTitle())
        );
    }
}
