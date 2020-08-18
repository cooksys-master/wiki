package com.cooksys.server.dto;

import com.cooksys.server.entity.Credentials;

public class ContentArchiveRequestDto {
    
    private Credentials credentials;

    public ContentArchiveRequestDto() {
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
    
}
