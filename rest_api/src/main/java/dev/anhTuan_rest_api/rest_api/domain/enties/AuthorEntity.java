package dev.anhTuan_rest_api.rest_api.domain.enties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_id_seq")
    private Long id;

    private String name;

    private Integer age;
}
