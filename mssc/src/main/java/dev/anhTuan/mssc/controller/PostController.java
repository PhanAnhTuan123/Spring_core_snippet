package dev.anhTuan.mssc.controller;

import dev.anhTuan.mssc.model.Post;
import dev.anhTuan.mssc.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Post>findAll(){
        return repository.findAll();
    }
}
