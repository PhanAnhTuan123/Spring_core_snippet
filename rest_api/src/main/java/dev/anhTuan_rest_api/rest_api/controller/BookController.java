package dev.anhTuan_rest_api.rest_api.controller;

import dev.anhTuan_rest_api.rest_api.domain.dto.BookDTO;
import dev.anhTuan_rest_api.rest_api.domain.enties.BookEntity;
import dev.anhTuan_rest_api.rest_api.mappers.Mapper;
import dev.anhTuan_rest_api.rest_api.services.BookServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private Mapper<BookEntity, BookDTO>bookMapper;
    private BookServices bookServices;

    public BookController(Mapper<BookEntity, BookDTO> bookMapper,BookServices bookServices) {
        this.bookMapper = bookMapper;
        this.bookServices = bookServices;
    }
    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDTO>createBook(@PathVariable("isbn") String isbn,
                                             @RequestBody BookDTO bookDTO){
        BookEntity bookEntity = bookMapper.mapFrom(bookDTO);
        BookEntity savedBook = bookServices.createUpdateBook(isbn,bookEntity);
        BookDTO savedBookDTO = bookMapper.mapTo(savedBook);
        return new ResponseEntity<>(savedBookDTO, HttpStatus.CREATED);
    }
}
