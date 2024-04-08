package dev.anhTuan_rest_api.rest_api;

import dev.anhTuan_rest_api.rest_api.domain.dto.AuthorDTO;
import dev.anhTuan_rest_api.rest_api.domain.dto.BookDTO;
import dev.anhTuan_rest_api.rest_api.domain.enties.AuthorEntity;
import dev.anhTuan_rest_api.rest_api.domain.enties.BookEntity;

public final class TestDataUtil {
    private TestDataUtil(){

    }
    public static AuthorEntity createTestAuthorEntityA(){
        return AuthorEntity.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }
    public static AuthorDTO createTestAuthorDtoA() {
        return AuthorDTO.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }
    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Thomas Cronin")
                .age(44)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Jesse A Casey")
                .age(24)
                .build();
    }

    public static BookEntity createTestBookEntityA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookDTO createTestBookDtoA(final AuthorDTO authorDto) {
        return BookDTO.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author(authorDto)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .authorEntity(authorEntity)
                .build();
    }


}
