package dev.anhTuan.dto_mapper.controller;

import dev.anhTuan.dto_mapper.domain.dto.AuthorDTO;
import dev.anhTuan.dto_mapper.domain.entities.AuthorEntity;
import dev.anhTuan.dto_mapper.mapper.Mapper;
import dev.anhTuan.dto_mapper.service.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthorController {
    private AuthorService authorService;

    private Mapper<AuthorEntity,AuthorDTO>authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity,AuthorDTO> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO author){
        AuthorEntity authorEntity = authorMapper.mapFrom(author);

        AuthorEntity savedAthorEntity = authorService.createAuthor(authorEntity);
        return authorMapper.mapTo(savedAthorEntity);

    }
}
