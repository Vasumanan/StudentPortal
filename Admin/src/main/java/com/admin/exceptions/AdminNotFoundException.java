package com.admin.exceptions;

public class AdminNotFoundException extends RuntimeException{
	
	public AdminNotFoundException () {
		super();
	}
	public AdminNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
