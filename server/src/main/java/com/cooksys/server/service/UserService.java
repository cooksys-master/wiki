package com.cooksys.server.service;

import java.util.List;

import com.cooksys.server.dto.UserRequestDto;
import com.cooksys.server.dto.UserResponseDto;
import com.cooksys.server.entity.Credentials;

public interface UserService {

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUser(String username);

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(String username, UserRequestDto userRequestDto);

    UserResponseDto deleteUser(String username, UserRequestDto userRequestDto);

    UserResponseDto loginUser(Credentials credentials);

}
