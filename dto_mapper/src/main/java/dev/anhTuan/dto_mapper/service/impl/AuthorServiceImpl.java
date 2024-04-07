package dev.anhTuan.dto_mapper.service.impl;

import dev.anhTuan.dto_mapper.domain.entities.AuthorEntity;
import dev.anhTuan.dto_mapper.repositories.AuthorRepository;
import dev.anhTuan.dto_mapper.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity author) {
//        authorRepository.save
        return authorRepository.save(author);
    }
}
