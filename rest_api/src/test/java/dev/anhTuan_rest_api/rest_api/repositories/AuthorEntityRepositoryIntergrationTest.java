package dev.anhTuan_rest_api.rest_api.repositories;

import dev.anhTuan_rest_api.rest_api.TestDataUtil;
import dev.anhTuan_rest_api.rest_api.domain.enties.AuthorEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorEntityRepositoryIntergrationTest {
    private AuthorRepository underTest;

    @Autowired
    public void setUnderTest(AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorEntity);
        Optional<AuthorEntity>result = underTest.findById(authorEntity.getId());
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get()).isEqualTo(authorEntity);
    }
    @Test
    public void testThatMultipleAuthorsCanbeCreatedAndRecalled(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorEntityA);
        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorB();
        underTest.save(authorEntityB);
        AuthorEntity authorEntityC = TestDataUtil.createTestAuthorC();
        underTest.save(authorEntityC);

        Iterable<AuthorEntity>result = underTest.findAll();
        Assertions.assertThat(result).hasSize(3)
                .containsExactly(authorEntityA,authorEntityB,authorEntityC);
    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorEntityA);
        authorEntityA.setName("UPDATED");
        underTest.save(authorEntityA);
        Optional<AuthorEntity>result = underTest.findById(authorEntityA.getId());
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get()).isEqualTo(authorEntityA);
    }

    @Test
    public void testThatGetAuthorsWithAgeLessThen(){
        AuthorEntity testAuthorAEntity = TestDataUtil.createTestAuthorEntityA();
        underTest.save(testAuthorAEntity);
        AuthorEntity testAuthorBEntity = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthorBEntity);
        AuthorEntity testAuthorCEntity = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthorCEntity);

        Iterable<AuthorEntity>result = underTest.ageLessThan(50);
        Assertions.assertThat(result).containsExactly(testAuthorBEntity,testAuthorCEntity);
    }
    @Test
    public void testThatGetAuthorsWithAgeGreaterThan(){
        AuthorEntity testAuthorAEntity = TestDataUtil.createTestAuthorEntityA();
        underTest.save(testAuthorAEntity);

        AuthorEntity testAuthorBEntity = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthorBEntity);

        AuthorEntity testAuthorCEntity = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthorCEntity);

        Iterable<AuthorEntity>result = underTest.findAuthorsWithAgeGreaterThan(50);
        Assertions.assertThat(result).containsExactly(testAuthorAEntity);
    }

}
