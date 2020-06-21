package com.initializer.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class ExceptionsHandler {
	
    @ExceptionHandler(value = {CompanyActionNotFoundExceptionHandler.class})
    public ResponseEntity<Void> companyActionNotFound(CompanyActionNotFoundExceptionHandler ex, WebRequest request) {
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    
//    @ExceptionHandler(value = {InvalidJwtAuthenticationException.class})
//    public ResponseEntity invalidJwtAuthentication(InvalidJwtAuthenticationException ex, WebRequest request) {
//        log.debug("handling InvalidJwtAuthenticationException...");
//        return status(UNAUTHORIZED).build();
//    }
}
