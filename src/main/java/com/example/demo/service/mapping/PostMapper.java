package com.example.demo.service.mapping;

import com.example.demo.api.dto.PostDto;
import com.example.demo.entity.PostEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto entityToDto(PostEntity postEntity);

    PostEntity dtoToEntity(PostDto postDto);

    List<PostEntity> dtosToEntities(List<PostDto> postDtos);

    List<PostDto> entitiesToDtos(List<PostEntity> postEntities);

}
