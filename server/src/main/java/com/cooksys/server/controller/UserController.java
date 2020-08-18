package com.cooksys.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.server.dto.UserRequestDto;
import com.cooksys.server.dto.UserResponseDto;
import com.cooksys.server.entity.Credentials;
import com.cooksys.server.errorhandling.RequestBodyIsNullException;
import com.cooksys.server.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET MAPPINGS

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public UserResponseDto getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    // POST MAPPINGS

    @PostMapping
    public UserResponseDto createUser(@RequestBody(required = false) UserRequestDto userRequestDto) {
        if (userRequestDto == null) {
            throw new RequestBodyIsNullException();
        }
        return userService.createUser(userRequestDto);
    }

    @PostMapping("/login")
    public UserResponseDto loginUser(@RequestBody(required = false) Credentials credentials) {
        if (credentials == null) {
            throw new RequestBodyIsNullException();
        }

        return userService.loginUser(credentials);
    }

    // PATCH MAPPINGS

    @PatchMapping("/{username}")
    public UserResponseDto updateUser(@PathVariable("username") String username,
            @RequestBody(required = false) UserRequestDto userRequestDto) {
        if (userRequestDto == null) {
            throw new RequestBodyIsNullException();
        }
        return userService.updateUser(username, userRequestDto);
    }

    // DELETE MAPPINGS

    @DeleteMapping("/{username}")
    public UserResponseDto deleteUser(@PathVariable("username") String username,
            @RequestBody(required = false) UserRequestDto userRequestDto) {
        if (userRequestDto == null) {
            throw new RequestBodyIsNullException();
        }
        return userService.deleteUser(username, userRequestDto);
    }

}
