package dev.anhTuan.dto_mapper.mapper.impl;

import dev.anhTuan.dto_mapper.domain.dto.AuthorDTO;
import dev.anhTuan.dto_mapper.domain.entities.AuthorEntity;
import dev.anhTuan.dto_mapper.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
@Component
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
