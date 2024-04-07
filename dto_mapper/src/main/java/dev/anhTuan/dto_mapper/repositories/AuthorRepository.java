package dev.anhTuan.dto_mapper.repositories;

import dev.anhTuan.dto_mapper.domain.entities.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<AuthorEntity,String> {

}
