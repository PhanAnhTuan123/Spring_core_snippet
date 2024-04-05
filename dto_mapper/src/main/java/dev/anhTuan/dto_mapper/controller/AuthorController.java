package dev.anhTuan.dto_mapper.controller;

import dev.anhTuan.dto_mapper.domain.Author;
import dev.anhTuan.dto_mapper.repositories.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthorController {
    private AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "/authors")
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }
}
