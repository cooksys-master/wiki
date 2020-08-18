package com.cooksys.server.errorhandling;

/**
 * RequestBodyIsNullException
 */
public class RequestBodyIsNullException extends GenericException {
    
    private static final long serialVersionUID = 3236512215981960763L;

    public RequestBodyIsNullException() {
        super("The Request Body is Null");
    }

    public RequestBodyIsNullException(String message) {
        super(message);
    }

}