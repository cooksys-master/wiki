package com.cooksys.server.errorhandling;

/**
 * RequiredFieldsMissingException
 */
public class RequiredFieldsMissingException extends GenericException {

    private static final long serialVersionUID = 6893198002371786956L;

    public RequiredFieldsMissingException() {
        super("The Required Fields are missing. The required Fields are username, password, and Email.");
    }

    public RequiredFieldsMissingException(String message) {
        super(message);
    }
}