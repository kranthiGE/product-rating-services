package com.rating.exception;

public class ResourceNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2937313936654271693L;

	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String message, Throwable th) {
		super(message, th);
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(Throwable th) {
		super(th);
	}
}
