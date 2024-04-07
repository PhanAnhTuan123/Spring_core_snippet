package dev.anhTuan_rest_api.rest_api.repositories;

import dev.anhTuan_rest_api.rest_api.domain.enties.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity,String> {

}
