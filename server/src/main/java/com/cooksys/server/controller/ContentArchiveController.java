package com.cooksys.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.server.dto.ContentArchiveRequestDto;
import com.cooksys.server.dto.ContentArchiveResponseDto;
import com.cooksys.server.dto.ContentResponseDto;
import com.cooksys.server.errorhandling.RequestBodyIsNullException;
import com.cooksys.server.service.ContentArchiveService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("page/archive")
public class ContentArchiveController {

    @Autowired
    private ContentArchiveService archiveService;

    @Autowired
    public ContentArchiveController(ContentArchiveService archiveServce) {
	this.archiveService = archiveServce;
    }
    
    @PostMapping("/{pageId}")
    public List<ContentArchiveResponseDto> getArchivedContentByPageId(@PathVariable("pageId") Long pageId,
	    @RequestBody(required = false) ContentArchiveRequestDto archiveRequestDto) {
	if(archiveRequestDto == null) {   
	    throw new RequestBodyIsNullException();
	}
	return archiveService.getArchivedContentByPageId(pageId, archiveRequestDto);
    }
    
    @PatchMapping("/rollback/{archiveId}")
    public ContentResponseDto rollbackContentByArchiveId(@PathVariable("archiveId") Long archiveId,
	    @RequestBody(required = false) ContentArchiveRequestDto archiveRequestDto) {
	if(archiveRequestDto == null) {
	    throw new RequestBodyIsNullException();
	}
	return archiveService.rollbackContent(archiveId, archiveRequestDto);
    }

}
