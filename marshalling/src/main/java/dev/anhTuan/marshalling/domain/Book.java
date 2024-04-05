package dev.anhTuan.marshalling.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String yearPublished;
}
