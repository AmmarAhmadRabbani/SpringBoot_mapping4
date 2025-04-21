package com.dailypractice.service;

import java.util.List;

import com.dailypractice.dto.UserDto;

public interface UserService {
	public UserDto addUser(UserDto userDto);

	public List<UserDto> getUsers();

	public UserDto getUserById(long userId);

//	public List<UserDto> get(long shoesId);

	public UserDto deleteUser(long userId);

	public UserDto updateUser(UserDto userDto);
}
