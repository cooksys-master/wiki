package com.cooksys.server.dto;

import java.util.Set;

import com.cooksys.server.entity.Credentials;
import com.cooksys.server.entity.Profile;

public class UserRequestDto {

    private Credentials credentials;
    private Profile profile;
    private Set<PermissionDto> permissions;

    public UserRequestDto() {
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionDto> permissions) {
        this.permissions = permissions;
    }
    
    
}
