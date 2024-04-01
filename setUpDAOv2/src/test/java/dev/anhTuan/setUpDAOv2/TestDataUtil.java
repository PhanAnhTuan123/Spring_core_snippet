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

    public static Book createTestBook() {
        return Book.builder()
                .isbn("987-1-233445-2")
                .title("The shadow in the Attic")
                .authorId(1L)
                .build();
    }
}
