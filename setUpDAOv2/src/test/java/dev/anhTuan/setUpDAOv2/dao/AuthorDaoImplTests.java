package dev.anhTuan.setUpDAOv2.dao;

import dev.anhTuan.setUpDAOv2.dao.impl.AuthorDaoImpl;
import dev.anhTuan.setUpDAOv2.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql(){
        Author author
                 = Author.builder()
                .id(1L)
                .name("Nguyen Van A")
                .age(25)
                .build();
        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors(id,name,age) values (?,?,?)"),
                eq(1L),eq("Nguyen van A"),eq(80)
            );
        }
    }
