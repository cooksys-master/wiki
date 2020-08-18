package com.cooksys.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.server.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findByMetadataDeletedFlagFalse();
    
    User findByCredentialsUsernameAndMetadataDeletedFlagFalse(String username);
    
    User findByCredentialsUsername(String username);
    
    User findByProfileEmail(String email);   
    
//    @Query("SELECT u.profile.email FROM User u INNER JOIN Permissions p WHERE p.id = 2")
//    List<String> findEmailByPermissions();
}
