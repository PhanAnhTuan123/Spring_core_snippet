package dev.anhTuan.setUpDAOv2;

import dev.anhTuan.setUpDAOv2.dao.impl.AuthorDaoImpl;
import dev.anhTuan.setUpDAOv2.dao.impl.BookDaoImpl;
import dev.anhTuan.setUpDAOv2.domain.Author;
import dev.anhTuan.setUpDAOv2.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntergrationTests {
    private BookDaoImpl underTest;
    private AuthorDaoImpl authorDao;

    @Autowired
    public void setUnderTest(BookDaoImpl underTest,AuthorDaoImpl authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }
    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);
        Book book = TestDataUtil.createTestBook();
        book.setAuthorId(author.getId());
//        Book book  = TestDataUtil.createTestBook();
        underTest.create(book);
        Optional<Book>result = underTest.find(book.getIsbn());
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get()).isEqualTo(book);

    }
}
