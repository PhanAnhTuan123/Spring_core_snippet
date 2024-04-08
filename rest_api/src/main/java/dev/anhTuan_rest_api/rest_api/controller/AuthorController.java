package dev.anhTuan_rest_api.rest_api.controller;

import dev.anhTuan_rest_api.rest_api.domain.dto.AuthorDTO;
import dev.anhTuan_rest_api.rest_api.domain.enties.AuthorEntity;
import dev.anhTuan_rest_api.rest_api.mappers.Mapper;
import dev.anhTuan_rest_api.rest_api.services.AuthorServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {
    private AuthorServices authorServices;

    private Mapper<AuthorEntity, AuthorDTO>authorMapper;

    public AuthorController(AuthorServices authorServices, Mapper<AuthorEntity, AuthorDTO> authorMapper) {
        this.authorServices = authorServices;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDTO>createAuthor(@RequestBody AuthorDTO author){
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorServices.save(authorEntity);

        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }
    @GetMapping(path = "/authors")
    public List<AuthorDTO>listAuthors(){
        List<AuthorEntity>authors =  authorServices.findAll();
        return authors.stream().map(authorMapper::mapTo).collect(Collectors.toList());
    }
}
