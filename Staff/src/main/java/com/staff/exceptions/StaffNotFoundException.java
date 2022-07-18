package com.staff.exceptions;

public class StaffNotFoundException extends RuntimeException{
	
	public StaffNotFoundException () {
		super();
	}
	public StaffNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
