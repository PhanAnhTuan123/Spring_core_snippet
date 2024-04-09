package dev.anhTuan_rest_api.rest_api.controller;

import dev.anhTuan_rest_api.rest_api.domain.dto.BookDTO;
import dev.anhTuan_rest_api.rest_api.domain.enties.BookEntity;
import dev.anhTuan_rest_api.rest_api.mappers.Mapper;
import dev.anhTuan_rest_api.rest_api.services.BookServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Optional;

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
    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDTO>getBook(@PathVariable("isbn") String isbn){
        Optional<BookEntity>foundBook = bookServices.findOne(isbn);
        return foundBook.map(bookEntity ->{
           BookDTO bookDTO = bookMapper.mapTo(bookEntity);
           return new ResponseEntity<>(bookDTO,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PatchMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDTO>partialUpdateBook(
            @PathVariable("isbn") String isbn,
            @RequestBody BookDTO bookDTO
            ){

        if(!bookServices.isExists(isbn)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BookEntity bookEntity = bookMapper.mapFrom(bookDTO);
        BookEntity updatedBookEntity = bookServices.partialUpdate(isbn,bookEntity);
        return new ResponseEntity<>(
                bookMapper.mapTo(updatedBookEntity),
                HttpStatus.OK
        );

    }
    @DeleteMapping(path = "/books/{isbn}")
    public  ResponseEntity deletedBook(@PathVariable("isbn") String isbn){
        bookServices.delete(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


        @RequestMapping(value = "/data", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
        @ResponseBody
        public String getData() {
            return "ahii";
        }


}
