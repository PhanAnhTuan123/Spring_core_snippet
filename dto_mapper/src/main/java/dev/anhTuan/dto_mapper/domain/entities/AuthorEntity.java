package dev.anhTuan.dto_mapper.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "authors")
@Data
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_id_seq")
    @SequenceGenerator(name = "author_id_seq",allocationSize = 1,initialValue = 1,sequenceName = "author_id_seq")
    private Long id;

    private String name;

    private Integer age;
}
