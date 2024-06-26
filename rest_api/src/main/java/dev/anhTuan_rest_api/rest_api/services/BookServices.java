package dev.anhTuan_rest_api.rest_api.services;

import dev.anhTuan_rest_api.rest_api.domain.enties.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookServices {
    BookEntity createUpdateBook(String isbn,BookEntity book);

    List<BookEntity>findAll();
    Optional<BookEntity>findOne(String isbn);
    boolean isExists(String isbn);


    BookEntity partialUpdate(String isbn, BookEntity bookEntity);

    void delete(String isbn);

    Page<BookEntity> findAll(Pageable pageable);

}
