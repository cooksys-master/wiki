package com.cooksys.server.entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usertable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Credentials credentials;

    @Embedded
    private Profile profile;

    // This is needed to initialize createdDate and deletedFlag
    @Embedded
    private Metadata metadata = new Metadata();
    
    @ManyToMany
    @JoinTable(
    name = "user_permissions",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name="permission_id"))
    List<Permissions> userPermissions;

    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Metadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
    
    public List<Permissions> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(List<Permissions> userPermissions) {
        this.userPermissions = userPermissions;
    }

}
