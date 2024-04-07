package dev.anhTuan.dto_mapper.service;


import dev.anhTuan.dto_mapper.domain.entities.AuthorEntity;
import org.springframework.stereotype.Service;


public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity author);
}
