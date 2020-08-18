package com.cooksys.server.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.server.dto.ContentArchiveRequestDto;
import com.cooksys.server.dto.ContentArchiveResponseDto;
import com.cooksys.server.entity.ContentArchive;

@Mapper(componentModel = "spring")
public interface ContentArchiveMapper {
    
    ContentArchive dtoToEntity(ContentArchiveRequestDto contentArchiveRequestDto);
    
    @Mapping(source="contentId.id", target="contentId")
    @Mapping(source="pageId.id", target="pageId")
    @Mapping(source="pageId.name", target="pageName")
    @Mapping(source="updatedBy.credentials.username", target="updatedBy")
    ContentArchiveResponseDto entityToDto(ContentArchive contentArchive);
    
    List<ContentArchiveResponseDto> entitiesToDtos(List<ContentArchive> contentArchiveList);

}
