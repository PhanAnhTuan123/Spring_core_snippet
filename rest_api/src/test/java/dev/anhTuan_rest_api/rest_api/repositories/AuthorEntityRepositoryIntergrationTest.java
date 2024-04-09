package dev.anhTuan_rest_api.rest_api.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.anhTuan_rest_api.rest_api.TestDataUtil;
import dev.anhTuan_rest_api.rest_api.domain.dto.AuthorDTO;
import dev.anhTuan_rest_api.rest_api.domain.enties.AuthorEntity;
import dev.anhTuan_rest_api.rest_api.mappers.impl.AuthorMapper;
import dev.anhTuan_rest_api.rest_api.mappers.impl.BookMapper;
import org.assertj.core.api.Assertions;
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

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AuthorEntityRepositoryIntergrationTest {
    private AuthorRepository underTest;
    private ObjectMapper objectMapper;

    private AuthorMapper authorMapper;

    private MockMvc mockMvc;
    @Autowired
    public void setUnderTest(AuthorRepository underTest,ObjectMapper objectMapper,MockMvc mockMvc,AuthorMapper authorMapper) {
        this.underTest = underTest;
        this.authorMapper =authorMapper;
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
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
    @Test
    public void testDeletedAuthor(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorEntityA();
        underTest.save(authorEntity);
        underTest.deleteById(authorEntity.getId());
        Optional<AuthorEntity>result = underTest.findById(authorEntity.getId());
        Assertions.assertThat(result).isEmpty();
    }
    @Test
    public void testThatCreateAuthorSucceessfullyReturnSavedAuthor()throws  Exception{
        AuthorDTO testAuthorDtoA = TestDataUtil.createTestAuthorDtoA();
        testAuthorDtoA.setId(null);
        String authorJson = objectMapper.writeValueAsString(testAuthorDtoA);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson)

        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.name").value("Abigail Rose")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.age").value(80)
        );

    }
    @Test
    public void testThatListAuthorsReturnHttpStatus200() throws  Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testThatListAuthorsReturnListOfAuthors() throws  Exception{
        AuthorEntity testAuthorA  = TestDataUtil.createTestAuthorEntityA();
        underTest.save(testAuthorA);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].name").value("Abigail Rose")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].age").value(80)
        );
    }
    @Test
    public void testThatGetAuthorsReturnsHttpsStatus200WhenAuthorExists() throws  Exception{
        AuthorEntity testAuthorA  = TestDataUtil.createTestAuthorEntityA();
        underTest.save(testAuthorA);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/authors/"+testAuthorA.getId())
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testThatGetAuthorReturnsHttpStatus404WhenAuthorNotExists()throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/authors/99")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    @Test
    public void testThatGetAuthorReturnsHttpStatus404WhenAuthorExists()throws Exception{

        AuthorEntity testAuthorA  = TestDataUtil.createTestAuthorEntityA();
        underTest.save(testAuthorA);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/authors/"+testAuthorA.getId())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.id").value(testAuthorA.getId())
                ).andExpect(
                        MockMvcResultMatchers.jsonPath("$.name").value(testAuthorA.getName())
                ).andExpect(
                        MockMvcResultMatchers.jsonPath("$.age").value(testAuthorA.getAge())
                );
    }
    @Test
    public void testThatFullUpdateAuthorReturnsHttpStatus404WhenNoAuthorExists()throws  Exception{
        AuthorDTO testAuthor = TestDataUtil.createTestAuthorDtoA();
        String result =  objectMapper.writeValueAsString(testAuthor);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/authors/222")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(result)
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    @Test
    public void testThatFullUpdateAuthorReturnsHttpStatus200isOk()throws  Exception{
        AuthorDTO testAuthor = TestDataUtil.createTestAuthorDtoA();
        underTest.save(authorMapper.mapFrom(testAuthor));
        String result =  objectMapper.writeValueAsString(testAuthor);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/authors/"+testAuthor.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(result)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testThatFullUpdateAuthorReturnsHttpUpdatesExiststingAuthor()throws  Exception{
        AuthorDTO testAuthor = TestDataUtil.createTestAuthorDtoA();
        underTest.save(authorMapper.mapFrom(testAuthor));
        String result =  objectMapper.writeValueAsString(testAuthor);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/authors/"+testAuthor.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(result)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(testAuthor.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(testAuthor.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(testAuthor.getAge()));
    }
    @Test
    public void testThatPartialUpdateExistingAuthorReturnsHttpStATus200k() throws  Exception{
        AuthorEntity testAuthorA = TestDataUtil.createTestAuthorB();
        AuthorEntity savedAuthor = underTest.save(testAuthorA);
        AuthorDTO testDTOA = TestDataUtil.createTestAuthorDtoA();
        testAuthorA.setName("UPDATED");
        String authorDtoJson = objectMapper.writeValueAsString(testDTOA);
        mockMvc.perform(
                MockMvcRequestBuilders.patch("/authors/"+savedAuthor.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorDtoJson)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testThatDeleteAuthorReturnHttp204ForNonExistingAuthor() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/authors/999")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

}
