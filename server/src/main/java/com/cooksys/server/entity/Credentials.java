package com.cooksys.server.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Credentials {

    @Column(nullable = false, unique = true)
    private String username;

    /**
     * password is a key word in Postgresql. Its not reserved, but best practices
     * say not to use them
     **/
    @Column(name = "pass_word", nullable = false)
    private String password;

    public Credentials() {
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

}

