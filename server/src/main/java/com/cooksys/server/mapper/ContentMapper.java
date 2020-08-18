package com.cooksys.server.mapper;

import java.util.List;

import com.cooksys.server.dto.ContentRequestDto;
import com.cooksys.server.dto.ContentResponseDto;
import com.cooksys.server.entity.Content;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContentMapper {

    Content requestDtoToEntity(ContentRequestDto contentRequestDto);

    ContentResponseDto entityToResponseDto(Content content);

    List<ContentResponseDto> entitiesToDtos(List<Content> sectionEntities);
}
