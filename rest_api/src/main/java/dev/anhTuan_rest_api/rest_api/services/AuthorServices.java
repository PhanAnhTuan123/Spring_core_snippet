package dev.anhTuan_rest_api.rest_api.services;

import dev.anhTuan_rest_api.rest_api.domain.enties.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorServices {
    AuthorEntity save(AuthorEntity authorEntity);

    List<AuthorEntity>findAll();

    Optional<AuthorEntity>findOne(Long id);
    boolean isExists(Long id);
}
