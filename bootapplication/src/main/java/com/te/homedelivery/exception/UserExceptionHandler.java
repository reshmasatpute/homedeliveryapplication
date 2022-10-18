package com.te.homedelivery.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.homedelivery.response.UserResponse;

@ControllerAdvice
public class UserExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserResponse> userNotFoundException(UserNotFoundException exception) {
		return ResponseEntity.ok(new UserResponse(true, exception.getMessage(), null));

	}
}
