package com.cooksys.server.dto;

public class PermissionDto {
    
    private Long id;
    private String permission;
    
    
    public PermissionDto() {
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPermission() {
        return permission;
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }

}
