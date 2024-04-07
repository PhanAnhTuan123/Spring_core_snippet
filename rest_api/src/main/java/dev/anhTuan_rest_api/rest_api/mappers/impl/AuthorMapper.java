package dev.anhTuan_rest_api.rest_api.mappers.impl;

import dev.anhTuan_rest_api.rest_api.domain.dto.AuthorDTO;
import dev.anhTuan_rest_api.rest_api.domain.enties.AuthorEntity;
import dev.anhTuan_rest_api.rest_api.mappers.Mapper;
import org.modelmapper.ModelMapper;

public class AuthorMapper implements Mapper<AuthorEntity, AuthorDTO> {

    private ModelMapper modelMapper;

    public AuthorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDTO mapTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity,AuthorDTO.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO,AuthorEntity.class);
    }
}
