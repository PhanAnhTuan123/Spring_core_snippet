package dev.anhTuan_rest_api.rest_api.services.impl;

import dev.anhTuan_rest_api.rest_api.domain.enties.BookEntity;
import dev.anhTuan_rest_api.rest_api.repositories.BookRepository;
import dev.anhTuan_rest_api.rest_api.services.BookServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class BookServiceImpl implements BookServices {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createUpdateBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }

    @Override
    public List<BookEntity> findAll() {
        return StreamSupport.stream(
                bookRepository.findAll().spliterator(),false
        ).collect(Collectors.toList());
    }

    @Override
    public Optional<BookEntity> findOne(String isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public boolean isExists(String isbn) {
        return bookRepository.existsById(isbn);
    }
}
