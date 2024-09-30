package com.toure.project.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.toure.project.exception.EntityNotFoundException;
import com.toure.project.exception.InvalidEntityException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest){
		
		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		
		final ErrorDto errorDto = ErrorDto.builder()
		.httpCode(notFound.value())
		.message(exception.getMessage())
		.code(exception.getErrorCodes())
		.build();
		
		
		return new ResponseEntity<>(errorDto,notFound);
	}
	
	@ExceptionHandler(InvalidEntityException.class)
	public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest){
		
		final HttpStatus badResquest = HttpStatus.BAD_REQUEST;
		
		final ErrorDto errorDto = ErrorDto.builder()
		.httpCode(badResquest.value())
		.code(exception.getErrorCodes())
		.message(exception.getMessage())
		.error(exception.getError())
		.build();
		
		return new ResponseEntity<>(errorDto, badResquest);
	}

}
