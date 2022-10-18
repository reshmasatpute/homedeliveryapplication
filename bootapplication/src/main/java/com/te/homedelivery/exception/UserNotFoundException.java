package com.te.homedelivery.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7510982998688544277L;

	public UserNotFoundException(String msg){
		super(msg);
	}
}
