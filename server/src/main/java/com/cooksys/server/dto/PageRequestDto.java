package com.cooksys.server.dto;

import com.cooksys.server.entity.Credentials;

public class PageRequestDto {

    private String name;
    private String type;
    private Long parentId;
    private Credentials credentials;

    public PageRequestDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

}
