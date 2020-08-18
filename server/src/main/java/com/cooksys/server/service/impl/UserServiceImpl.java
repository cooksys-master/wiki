package com.cooksys.server.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.server.dto.UserRequestDto;
import com.cooksys.server.dto.UserResponseDto;
import com.cooksys.server.entity.Credentials;
import com.cooksys.server.entity.User;
import com.cooksys.server.errorhandling.UserAlreadyExistsException;
import com.cooksys.server.mapper.UserMapper;
import com.cooksys.server.repository.UserRepository;
import com.cooksys.server.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private UserMapper userMapper;
	private UserServiceMethods userServiceMethods = new UserServiceMethods();

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	// Read Services

	@Override
	public List<UserResponseDto> getAllUsers() {
		return userMapper.entitiesToDtos(userRepository.findByMetadataDeletedFlagFalse());
	}

	@Override
	public UserResponseDto getUser(String username) {
		User user = userRepository.findByCredentialsUsername(username);
		userServiceMethods.verifyUser(user);
		return userMapper.entityToDto(user);
	}

	// Write services

	@Override
	public UserResponseDto createUser(UserRequestDto userRequestDto) {
		User user = userMapper.requestDtoToEntity(userRequestDto);
		UserResponseDto userResponseDto = checkDeletedUser(user.getCredentials().getUsername());
		return userResponseDto != null ? userResponseDto : newUser(userRequestDto, user);
	}

	@Override
	public UserResponseDto loginUser(Credentials credentials) {
		User user = userRepository.findByCredentialsUsername(credentials.getUsername());
		userServiceMethods.checkUserCredentials(user, credentials);
		return userMapper.entityToDto(user);
	}

	// Update/Patch services

	@Override
	public UserResponseDto updateUser(String username, UserRequestDto userRequestDto) {
		User user = userRepository.findByCredentialsUsername(username);
		userServiceMethods.checkUserCredentials(user, userRequestDto.getCredentials());
		user.setCredentials(userRequestDto.getCredentials());
		user.setProfile(userRequestDto.getProfile());
		user.getMetadata().setUpdatedDate(LocalDate.now());
		userRepository.saveAndFlush(user);
		return userMapper.entityToDto(user);
	}

	// Delete Services

	@Override
	public UserResponseDto deleteUser(String username, UserRequestDto userRequestDto) {

		// userRequestDto can be used later on to get information about
		// the person doing the deleting to make sure they are an admin and
		// have the ability to delete other users

		User userToDelete = userRepository.findByCredentialsUsername(username);
		userServiceMethods.checkUserCredentials(userToDelete, userRequestDto.getCredentials());

		userToDelete.getMetadata().setDeletedFlag(true);
		userToDelete.getMetadata().setDeletedDate(LocalDate.now());
		userRepository.saveAndFlush(userToDelete);
		return userMapper.entityToDto(userToDelete);
	}

	// Helper Methods for creating a user

	private UserResponseDto checkDeletedUser(String username) {
		User user = userRepository.findByCredentialsUsername(username);
		if (user != null) {
			Boolean deletedFlag = user.getMetadata().getDeletedFlag();
			if (deletedFlag) {
				user.getMetadata().setDeletedFlag(false);
				user.getMetadata().setDeletedDate(null);
				user.getMetadata().setUpdatedDate(LocalDate.now());
				userRepository.saveAndFlush(user);
				return userMapper.entityToDto(user);
			}
			throw new UserAlreadyExistsException("The Username already Exists. Please Select anothe username. ");
		}
		return null;
	}

	private UserResponseDto newUser(UserRequestDto userRequestDto, User user) {
		if (emailExists(userRequestDto.getProfile().getEmail())) {
			throw new UserAlreadyExistsException("The Email has already been taken. Please Select another Email");
		}
		userServiceMethods.checkRequiredFields(user);
		userRepository.saveAndFlush(user);
		return userMapper.entityToDto(user);
	}

	private boolean emailExists(String email) {
		return userRepository.findByProfileEmail(email) != null;
	}

}
