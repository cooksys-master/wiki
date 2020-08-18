package com.cooksys.server.dto;

import java.time.LocalDate;
import java.util.Set;

import com.cooksys.server.entity.Profile;

public class UserResponseDto {

    private String username;
    private Profile profile;
    private LocalDate createdDate;
    private Set<PermissionDto> permissions;

    public UserResponseDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Profile getProfile() {
        return profile;
    }
    
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
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
