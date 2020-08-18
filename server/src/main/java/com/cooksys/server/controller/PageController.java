package com.cooksys.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.server.dto.PageRequestDto;
import com.cooksys.server.dto.PageResponseDto;
import com.cooksys.server.entity.Credentials;
import com.cooksys.server.errorhandling.RequestBodyIsNullException;
import com.cooksys.server.service.PageService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("page")
public class PageController {

    private PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/{id}")
    public PageResponseDto getPageById(@PathVariable("id") Long id) {
	return pageService.getPageById(id);
    }

    @PostMapping
    public PageResponseDto postPage(@RequestBody(required = false) PageRequestDto pageRequestDto) {
        if (pageRequestDto == null) {
            throw new RequestBodyIsNullException();
        }
        return pageService.postPage(pageRequestDto);
    }

    @PatchMapping("/{id}")
    public PageResponseDto updatePageTitle(@PathVariable("id") Long id,
            @RequestBody(required = false) PageRequestDto pageRequestDto) {
        if (pageRequestDto == null) {
            throw new RequestBodyIsNullException();
        }
	return pageService.updatePageTitle(id, pageRequestDto);
    }

    @DeleteMapping("/{id}")
    public PageResponseDto deletePage(@PathVariable("id") Long id,
            @RequestBody(required = false) Credentials credentials) {
        if (credentials == null) {
            throw new RequestBodyIsNullException();
        }
	return pageService.deletePage(id, credentials);
    }

}