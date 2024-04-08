package dev.anhTuan_rest_api.rest_api.mappers.impl;

import dev.anhTuan_rest_api.rest_api.domain.dto.BookDTO;
import dev.anhTuan_rest_api.rest_api.domain.enties.BookEntity;
import dev.anhTuan_rest_api.rest_api.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<BookEntity, BookDTO> {

    private ModelMapper modelMapper;

    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDTO mapTo(BookEntity bookEntity) {
        return modelMapper.map(bookEntity,BookDTO.class);
    }

    @Override
    public BookEntity mapFrom(BookDTO bookDTO) {
        return modelMapper.map(bookDTO,BookEntity.class);
    }
}
