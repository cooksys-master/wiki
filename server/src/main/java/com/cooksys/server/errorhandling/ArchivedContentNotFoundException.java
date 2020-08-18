package com.cooksys.server.errorhandling;

public class ArchivedContentNotFoundException extends GenericException {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ArchivedContentNotFoundException() {
	super("Archived content not found.");
    }

    public ArchivedContentNotFoundException(String message) {
	super(message);
    }
}
