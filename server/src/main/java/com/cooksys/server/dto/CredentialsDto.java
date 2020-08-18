package com.cooksys.server.dto;

public class CredentialsDto {

    private String username;
    private String password;

    public CredentialsDto() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
