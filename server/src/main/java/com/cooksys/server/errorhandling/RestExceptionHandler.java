package com.cooksys.server.errorhandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * RestExceptionHandler
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleGeneralException(GenericException e, WebRequest request) {
        return handleReturnMessage(e, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = RequestBodyIsNullException.class)
    public ResponseEntity<Object> handleRequestBodyIsNullException(RequestBodyIsNullException e, WebRequest request) {
        return handleReturnMessage(e, HttpStatus.CONFLICT, request);
    }

    private ResponseEntity<Object> handleReturnMessage(GenericException e, HttpStatus code, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), code, request);
    }
}