package com.cooksys.server.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.server.dto.PageRequestDto;
import com.cooksys.server.dto.PageResponseDto;
import com.cooksys.server.dto.PageSimpleResponseDto;
import com.cooksys.server.entity.Page;

@Mapper(componentModel = "spring")
public interface PageMapper {
    
    Page dtoToEntity(PageRequestDto pageRequestDto);    

    @Mapping(target="parentId", source="parent.id")
    @Mapping(target="subPageList", source="subPageList")
    @Mapping(target="metadata.deletedBy", source="metadata.deletedBy.credentials.username")
    @Mapping(target="metadata.updatedBy", source="metadata.updatedBy.credentials.username")
    @Mapping(target="metadata.createdBy", source="metadata.createdBy.credentials.username")
    PageResponseDto entityToDto(Page page);

    
    List<PageSimpleResponseDto> entitiesToDtos(List<Page> pages);

}
