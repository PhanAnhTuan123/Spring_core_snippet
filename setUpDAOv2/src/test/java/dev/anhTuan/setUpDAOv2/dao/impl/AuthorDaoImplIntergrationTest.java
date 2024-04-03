package dev.anhTuan.setUpDAOv2.dao.impl;

import dev.anhTuan.setUpDAOv2.TestDataUtil;
import dev.anhTuan.setUpDAOv2.domain.Author;
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
public class AuthorDaoImplIntergrationTest {

    private AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntergrationTest(AuthorDaoImpl underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        underTest.findOne(author.getId());
        Optional<Author>result = underTest.findOne(author.getId());
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get()).isEqualTo(author);
    }
    @Test
    public void testThatMultipleAuthorCanbeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.create(authorB);
        Author authorC = TestDataUtil.createTestAuthorC();
        underTest.create(authorC);

        List<Author>result = underTest.find();
        Assertions.assertThat(result)
                .hasSize(3).containsExactly(author,authorB,authorC);
    }

}
