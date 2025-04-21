package com.dailypractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private long userId;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String facebookId;
	private String googleId;
	

}
