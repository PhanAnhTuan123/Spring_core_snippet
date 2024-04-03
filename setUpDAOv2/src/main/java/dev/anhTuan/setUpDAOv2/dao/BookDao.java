package dev.anhTuan.setUpDAOv2.dao;

import dev.anhTuan.setUpDAOv2.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> find(String isbn);

    List<Book> findMany();

    void update(String s, Book book);
}
