package com.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionErreur extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public ExceptionErreur(String message) {
		super(message);
	}

}