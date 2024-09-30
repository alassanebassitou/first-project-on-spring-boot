package com.toure.project.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {
	
	@Getter
	private ErrorCodes errorCodes;
	
	private List<String> error = new ArrayList<>();	
	public EntityNotFoundException(String message) {
		super(message);
	}
	
	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCode) {
		super(message, cause);
		this.errorCodes = errorCode;
	}
	
	public EntityNotFoundException(String message, ErrorCodes errorCode) {
		super(message);
		this.errorCodes = errorCode;
	}
	
	public EntityNotFoundException(String message, ErrorCodes errorCode, List<String> error) {
		super(message);
		this.errorCodes = errorCode;
		this.error = error;
	}

}
