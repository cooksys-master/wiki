package com.cooksys.server.errorhandling;

/**
 * UserAlreadyExistsException
 */
public class UserAlreadyExistsException extends GenericException {

    private static final long serialVersionUID = -6692498248386244476L;

    public UserAlreadyExistsException() {
        super("This Username or Email Already Exists. ");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}