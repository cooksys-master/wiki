package com.cooksys.server.errorhandling;

/**
 * UserNotFoundException
 */
public class UserNotFoundException extends GenericException {

    /**
     *
     */
    private static final long serialVersionUID = 6855042463371091968L;

    public UserNotFoundException() {
        super("The User requested does not Exists. Please request a viable User.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    
}