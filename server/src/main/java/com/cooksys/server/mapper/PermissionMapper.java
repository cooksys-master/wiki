package com.cooksys.server.mapper;

import org.mapstruct.Mapper;

import com.cooksys.server.dto.PermissionDto;
import com.cooksys.server.entity.Permissions;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionDto entityToDto(Permissions permission);
    
    Permissions dtoToEntity(PermissionDto permissionDto);

}
