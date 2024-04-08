package dev.anhTuan_rest_api.rest_api.domain.dto;

import dev.anhTuan_rest_api.rest_api.domain.enties.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private String isbn;

    private String title;

    private AuthorDTO author;
}
