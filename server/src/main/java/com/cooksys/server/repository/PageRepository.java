package com.cooksys.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.server.entity.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    public Page findByNameAndMetadataDeletedFlagFalse(String name);

    public Page findByIdAndMetadataDeletedFlagFalse(Long id);

}
