package com.pm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomEntityResponseExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectIdException(ProjectIdException idExcep, WebRequest request){
		ProjectIdExceptionResponse exceptionREsponse = new ProjectIdExceptionResponse(idExcep.getMessage());
		return new ResponseEntity(exceptionREsponse,HttpStatus.BAD_REQUEST);
	}
}
