package dev.anhTuan.setUpDAOv2.dao.impl;

import dev.anhTuan.setUpDAOv2.TestDataUtil;
import dev.anhTuan.setUpDAOv2.dao.impl.AuthorDaoImpl;
import dev.anhTuan.setUpDAOv2.dao.impl.BookDaoImpl;
import dev.anhTuan.setUpDAOv2.domain.Author;
import dev.anhTuan.setUpDAOv2.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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
    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);
        Book book = TestDataUtil.createTestBook();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Book bookB = TestDataUtil.createTestBookB();
        bookB.setAuthorId(author.getId());
        underTest.create(bookB);

        Book bookC = TestDataUtil.createTestBookC();
        bookC.setAuthorId(author.getId());
        underTest.create(bookC);

        List<Book> result = underTest.findMany();
        Assertions.assertThat(result).hasSize(3).containsExactly(book,bookB,bookC);

    }
    @Test
    public void testThatBookCanBeUpdated(){
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);

        Book bookA = TestDataUtil.createTestBook();
        bookA.setAuthorId(author.getId());

        bookA.setTitle("UPDATED");
        underTest.update(bookA.getIsbn(),bookA);

        Optional<Book>result = underTest.find(bookA.getIsbn());
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get()).isEqualTo(bookA);
    }
}
