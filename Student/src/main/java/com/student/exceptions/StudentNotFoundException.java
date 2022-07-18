package com.student.exceptions;


public class StudentNotFoundException extends RuntimeException{
	
	public StudentNotFoundException() {
		super();
	}
	
	public StudentNotFoundException (String errorMessage) {
		super(errorMessage);
	}
}