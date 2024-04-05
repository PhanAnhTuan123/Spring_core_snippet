package dev.anhTuan.dto_mapper.repositories;

import dev.anhTuan.dto_mapper.domain.Author;
import org.springframework.stereotype.Service;


public interface AuthorService {
    Author createAuthor(Author author);
}
