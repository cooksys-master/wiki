package com.cooksys.server.errorhandling;

/**
 * UserDoesNotMatchCredentialsException
 */
public class UserDoesNotMatchCredentialsException extends GenericException {

    private static final long serialVersionUID = 290529876890183311L;

    public UserDoesNotMatchCredentialsException() {
        super("The Username and the Credentials Request do not match, or the password is wrong");
    }

    public UserDoesNotMatchCredentialsException(String message) {
        super(message);
    }

}