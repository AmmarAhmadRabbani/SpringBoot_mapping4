package com.dailypractice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailypractice.dto.UserDto;
import com.dailypractice.entity.User;
import com.dailypractice.exceptiom.UserNotFoundException;
import com.dailypractice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;
//	@Autowired
//	private ShoesRepository shoesRepository;

	@Override
	public UserDto addUser(UserDto userDto) {
		if (userDto != null) {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);
			User save = repository.save(user);
			BeanUtils.copyProperties(save, userDto);
			return userDto;
		}

		throw new UserNotFoundException("user not present");
	}

	@Override
	public List<UserDto> getUsers() {
		List<User> users = repository.findAll();
		List<UserDto> userDtosList = new ArrayList<>();
		if (users.isEmpty()) {
			throw new UserNotFoundException("users not present");
		}
		users.forEach(i -> {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(i, userDto);
			userDtosList.add(userDto);
		});

		return userDtosList;
	}

	@Override
	public UserDto getUserById(long userId) {
		User user = repository.findById(userId).orElseThrow(() -> new UserNotFoundException("invalid id"));
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;

	}

	@Override
	public UserDto deleteUser(long userId) {
		repository.findById(userId).orElseThrow(() -> new UserNotFoundException("invalid user id"));
		repository.deleteById(userId);
		return new UserDto();
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		User user = repository.findById(userDto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("id not avaliable"));
		BeanUtils.copyProperties(userDto, user);
		User save = repository.save(user);
		BeanUtils.copyProperties(save, userDto);

		return userDto;
	}

//	@Override
//	public List<UserDto> get(long shoesId) {
//		Shoes shoes = shoesRepository.findById(shoesId).orElseThrow(() -> new UserNotFoundException("invalid id"));
//		List<User> users = shoes.getUsers();
//		List<UserDto> userDtos = new ArrayList<>();
//		users.forEach(i -> {
//			UserDto dto = new UserDto();
//			BeanUtils.copyProperties(i, dto);
//			userDtos.add(dto);
//		});
//		return userDtos;
//	}

}
