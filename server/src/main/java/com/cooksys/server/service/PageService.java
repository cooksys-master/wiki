package com.cooksys.server.service;

import com.cooksys.server.dto.PageRequestDto;
import com.cooksys.server.dto.PageResponseDto;
import com.cooksys.server.entity.Credentials;

/**
 * PageService
 */
public interface PageService {

    	PageResponseDto getPageById(Long id);

	PageResponseDto postPage(PageRequestDto pageRequestDto);

	PageResponseDto updatePageTitle(Long id, PageRequestDto pageRequestDto);

	PageResponseDto deletePage(Long id, Credentials credentials);
    
}