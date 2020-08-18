package com.cooksys.server.mapper;

import java.util.List;

import com.cooksys.server.dto.CredentialsDto;
import com.cooksys.server.dto.UserRequestDto;
import com.cooksys.server.dto.UserResponseDto;
import com.cooksys.server.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User credentialsDtoToEntity(CredentialsDto credentialsDto);

    @Mapping(target = "userPermissions", source = "permissions")
    User requestDtoToEntity(UserRequestDto userRequestDto);

    @Mapping(target = "username", source = "credentials.username")
    @Mapping(target = "createdDate", source = "metadata.createdDate")
    @Mapping(target = "permissions", source = "userPermissions")
    UserResponseDto entityToDto(User user);

    List<UserResponseDto> entitiesToDtos(List<User> userEntities);

}
