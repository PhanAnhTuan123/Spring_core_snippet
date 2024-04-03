package dev.anhTuan.setUpDAOv2;

import dev.anhTuan.setUpDAOv2.domain.Author;
import dev.anhTuan.setUpDAOv2.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Nguyen Van A")
                .age(25)
                .build();
    }
    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Nguyen Van B")
                .age(25)
                .build();
    }
    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Nguyen Van C")
                .age(25)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("987-1-233445-2")
                .title("The shadow in the Attic")
                .authorId(1L)
                .build();
    }
    public static Book createTestBookB() {
        return Book.builder()
                .isbn("987-1-276348-45")
                .title("Adventure of cricken")
                .authorId(2L)
                .build();
    }
    public static Book createTestBookC() {
        return Book.builder()
                .isbn("987-1-23233-22")
                .title("The atlantic of Human")
                .authorId(3L)
                .build();
    }
}
