package com.dailypractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailypractice.dto.UserDto;
import com.dailypractice.response.SuccessResponse;
import com.dailypractice.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/addUser")
	public ResponseEntity<SuccessResponse> addUser(@RequestBody UserDto userDto) {
		UserDto addUser = service.addUser(userDto);
		if (addUser != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "added successfully", addUser), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "adding failed", null), HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getUser")
	public ResponseEntity<SuccessResponse> getUser() {
		List<UserDto> users = service.getUsers();
		if (users != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "get successfull", users), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "failed", null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<SuccessResponse> getUserById(@PathVariable long userId) {
		UserDto userById = service.getUserById(userId);
		if (userById != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "successful", userById), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "getting failed", null), HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/updateUser")
	public ResponseEntity<SuccessResponse> updateUser(@RequestBody UserDto userDto) {
		UserDto updateUser = service.updateUser(userDto);
		if (updateUser != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "updated", updateUser), HttpStatus.OK);
		}

		return new ResponseEntity<>(new SuccessResponse(true, "not updated", null), HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<SuccessResponse> deleteUser(@PathVariable long userId) {
		UserDto deleteUser = service.deleteUser(userId);
		if (deleteUser != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "deleted", deleteUser), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "not deleted", null), HttpStatus.BAD_REQUEST);
	}

//	@GetMapping("get/{shoesId}")
//	public ResponseEntity<SuccessResponse> get(@PathVariable long shoesId) {
//		List<UserDto> list = service.get(shoesId);
//		if (list != null) {
//			return new ResponseEntity<>(new SuccessResponse(false, "get done", list), HttpStatus.OK);
//		}
//		return new ResponseEntity<>(new SuccessResponse(true, "getting not done", null), HttpStatus.BAD_REQUEST);
//	}

}
