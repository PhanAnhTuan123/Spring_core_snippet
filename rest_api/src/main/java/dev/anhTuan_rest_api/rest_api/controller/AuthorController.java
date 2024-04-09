package dev.anhTuan_rest_api.rest_api.controller;

import dev.anhTuan_rest_api.rest_api.domain.dto.AuthorDTO;
import dev.anhTuan_rest_api.rest_api.domain.enties.AuthorEntity;
import dev.anhTuan_rest_api.rest_api.mappers.Mapper;
import dev.anhTuan_rest_api.rest_api.services.AuthorServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    @GetMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDTO>getAuthor(@PathVariable("id") Long id){
        Optional<AuthorEntity>foundAuthor = authorServices.findOne(id);
        return foundAuthor.map(authorEntity -> {
            AuthorDTO authorDTO = authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDTO,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDTO>fullUpdateAuthor(@PathVariable("id") Long id
    , @RequestBody AuthorDTO authorDTO
    ){
        if(!authorServices.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        authorDTO.setId(id);
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDTO);
        AuthorEntity savedAuthorEntity = authorServices.save(authorEntity);

        return new ResponseEntity<>(
                authorMapper.mapTo(savedAuthorEntity),HttpStatus.OK
        );
    }
    @PatchMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDTO>partialUpdate(
            @PathVariable("id") Long id,
            @RequestBody AuthorDTO authorDTO
    ){
        if(!authorServices.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDTO);
        AuthorEntity updatedAuthor = authorServices.partialUpdate(id,authorEntity);
        return new ResponseEntity<>(
                authorMapper.mapTo(updatedAuthor),
                HttpStatus.OK
        );
    }
    @DeleteMapping(path = "/authors/{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") Long id){
        authorServices.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
