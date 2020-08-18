package com.cooksys.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.server.entity.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    
    public Content findContentById(Long Id);
    
    

}
