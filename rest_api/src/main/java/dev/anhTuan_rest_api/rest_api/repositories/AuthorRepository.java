package dev.anhTuan_rest_api.rest_api.repositories;

import dev.anhTuan_rest_api.rest_api.domain.enties.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity,Long> {

    Iterable<AuthorEntity>ageLessThan(int age);

    @Query("Select a from AuthorEntity a where a.age > ?1")
    Iterable<AuthorEntity>findAuthorsWithAgeGreaterThan(int age);
}
