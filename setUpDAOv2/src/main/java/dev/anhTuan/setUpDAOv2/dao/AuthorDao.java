package dev.anhTuan.setUpDAOv2.dao;

import dev.anhTuan.setUpDAOv2.domain.Author;
import dev.anhTuan.setUpDAOv2.domain.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author>findOne(long l);


    List<Author> find();

    List<Author> findMany();

    void update(long id,Author author);

    void delete(long id);
}
