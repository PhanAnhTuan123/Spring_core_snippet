package dev.anhTuan.setUpDAOv2.dao.impl;

import dev.anhTuan.setUpDAOv2.TestDataUtil;
import dev.anhTuan.setUpDAOv2.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
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
        Book book = TestDataUtil.createTestBook();
        underTest.create(book);
        verify (jdbcTemplate).update(eq("INSERT INTO books (isbn,title,authorId) values (?,?,?)"),
                eq("987-1-233445-2"),eq("The shadow in the Attic"),eq(1L));

    }

    @Test
    public void testThatFindOneGeneratesCorrectSql(){
        underTest.find("987-1-233445-2");
        verify(jdbcTemplate).query(eq("SELECT isbn,title,authorId from books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("987-1-233445-2"));
    }
    @Test
    public void testThatFindGenertesCorrectSql(){
        underTest.findMany();
        verify(jdbcTemplate).query(eq("Select isbn,title,author_id from books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any());
    }
    @Test
    public void testThatUpdateGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBook();
        underTest.update("987-1-233445-2",book);
        verify(jdbcTemplate).update("UPDATE books set isbn = ?,author_id = ? where isbn = ?",
                1L,"Nguyen Van A","987-1-233445-2");
    }
    @Test
    public void testThatDeleteGeneratesCorrectSql(){
        underTest.delete("987-1-233445-2");
        verify(jdbcTemplate).update("DELETE  from books where isbn = ?","987-1-233445-2");
    }
}
