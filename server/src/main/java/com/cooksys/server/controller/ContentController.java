package com.cooksys.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.server.dto.ContentRequestDto;
import com.cooksys.server.dto.ContentResponseDto;
import com.cooksys.server.errorhandling.RequestBodyIsNullException;
import com.cooksys.server.service.ContentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("page/content")
public class ContentController {
    
    private ContentService contentService;
    
    @Autowired
    public ContentController(ContentService contentService) {
	this.contentService = contentService;
    }
       
//    // Patch Mappings
//    
    @PatchMapping("/{pageId}")
    public ContentResponseDto updateSection(@PathVariable("pageId") Long pageId,
	    @RequestBody(required = false) ContentRequestDto contentRequestDto) {
	if(contentRequestDto == null) {
	    throw new RequestBodyIsNullException();
    }
	return contentService.updateContent(pageId, contentRequestDto);
    }
    
}
