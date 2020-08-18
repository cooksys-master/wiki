package com.cooksys.server.errorhandling;

/**
 * GenericException
 */
public class GenericException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 4502325807923863825L;

    public GenericException(String message) {
        super(message);
    }

    public GenericException() {
        super("TTheir was an Error With the Request");
    }
}