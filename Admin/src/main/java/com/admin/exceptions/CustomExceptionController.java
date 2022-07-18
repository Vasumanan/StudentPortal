package com.admin.exceptions;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * This CustomExceptionController is used handle all custom exceptions.
 * 
 * @author Vasumanan J
 *
 */
@RestControllerAdvice
public class CustomExceptionController {

	@ExceptionHandler(value = AdminNotFoundException.class)
	public ResponseEntity<Object> handleAdminNotFoundException(AdminNotFoundException exception,
			WebRequest request) {
		ExceptionResponse AdminNotFoundExceptionResponse = new ExceptionResponse(LocalDate.now(),
				exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(AdminNotFoundExceptionResponse, HttpStatus.NOT_FOUND);
	}
}