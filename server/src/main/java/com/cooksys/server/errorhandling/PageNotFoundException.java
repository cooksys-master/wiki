package com.cooksys.server.errorhandling;

/**
 * PageNotFound
 */
public class PageNotFoundException extends GenericException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PageNotFoundException() {
        super("The Page you requested is Not found");
    }

    public PageNotFoundException(String message) {
        super(message);
    }
    
}