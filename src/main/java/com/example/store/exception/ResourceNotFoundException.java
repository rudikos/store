package com.example.store.exception;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
public class ResourceNotFoundException extends Exception {

	public ResourceNotFoundException() {
		super();
	}
	public ResourceNotFoundException(final String message) {
		super(message);
	}
	public ResourceNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}
	public ResourceNotFoundException(final Throwable cause) {
		super(cause);
	}
}
