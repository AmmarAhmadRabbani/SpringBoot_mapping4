package com.dailypractice.exceptiom;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String messege) {
		super(messege);
	}

}
