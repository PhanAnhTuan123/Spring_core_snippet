package dev.anhTuan.setUpDAOv2.dao;

import dev.anhTuan.setUpDAOv2.dao.impl.BookDaoImpl;
import dev.anhTuan.setUpDAOv2.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql(){
        Book book = Book.builder()
                .isbn("987-1-233445-2")
                .title("The shadow in the Attic")
                .authorId(1L)
                .build();
        underTest.create(book);
        verify (jdbcTemplate).update(eq("INSERT INTO books (isbn,title,author_id) values (?,?,?)"),
                eq("987-1-233445-2"),eq("The shadow in the Attic"),eq(1L));

    }

}
