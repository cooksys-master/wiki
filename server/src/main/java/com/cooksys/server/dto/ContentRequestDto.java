package com.cooksys.server.dto;

import com.cooksys.server.entity.Credentials;

public class ContentRequestDto {

    
    private String content;
    private Credentials credentials;

    public ContentRequestDto() {
    }


    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Credentials getCredentials() {
        return this.credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }


    @Override
    public String toString() {
	return "ContentRequestDto [content=" + content + ", credentials=" + credentials + "]";
    }
    


}
