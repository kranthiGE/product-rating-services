package com.rating.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public RestResponseEntityExceptionHandler() {
		super();
	}
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleBadRequest(final ResourceNotFoundException ex, final WebRequest webRequest){
		return handleExceptionInternal(ex, getMessageBody(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
	}
	
	private ApiError getMessageBody(HttpStatus status, Exception ex) {
		String devMessage = ExceptionUtils.getRootCauseMessage(ex);
		return new ApiError(status, ex.getMessage(), devMessage);
	}
}
