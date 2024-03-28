package dev.anhTuan.databasePostgre.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Books {
    private String isbn;

    private String title;

    private Long authorId;
}
