package com.example.demo.service.mapping;

import com.example.demo.api.dto.TodoDto;
import com.example.demo.entity.TodoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    TodoDto entityToDto(TodoEntity todoEntity);

    TodoEntity dtoToEntity(TodoDto todoDto);

}
