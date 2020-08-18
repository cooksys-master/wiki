package com.cooksys.server.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.server.dto.PageRequestDto;
import com.cooksys.server.dto.PageResponseDto;
import com.cooksys.server.entity.Credentials;
import com.cooksys.server.entity.Page;
import com.cooksys.server.entity.User;
import com.cooksys.server.errorhandling.PageNotFoundException;
import com.cooksys.server.mailer.Mailer;
import com.cooksys.server.mapper.PageMapper;
import com.cooksys.server.repository.PageRepository;
import com.cooksys.server.repository.UserRepository;
import com.cooksys.server.service.PageService;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    PageRepository pageRepository;
    UserRepository userRepository;
    @Autowired
    PageMapper pageMapper;
    private UserServiceMethods userServiceMethods = new UserServiceMethods();

    @Autowired
    public PageServiceImpl(PageRepository pageRepository, PageMapper pageMapper, UserRepository userRepository) {
	this.pageRepository = pageRepository;
	this.pageMapper = pageMapper;
	this.userRepository = userRepository;
    }

    @Override
    public PageResponseDto getPageById(Long id) {
	Page pageResult = checkPage(id);
	List<Page> subPagesList = pageResult.getSubPageList();
	List<Page> filteredSubPageList = subPagesList.stream().filter(page -> !page.getMetadata().getDeletedFlag())
		.collect(Collectors.toList());
	pageResult.setSubPageList(filteredSubPageList);
	return pageMapper.entityToDto(pageResult);
    }

    @Override
    public PageResponseDto postPage(PageRequestDto pageRequestDto) {
	User user = userRepository.findByCredentialsUsername(pageRequestDto.getCredentials().getUsername());
	userServiceMethods.checkUserCredentials(user, pageRequestDto.getCredentials());

	Page page = pageMapper.dtoToEntity(pageRequestDto);
	Page parent = pageRepository.findByIdAndMetadataDeletedFlagFalse(pageRequestDto.getParentId());

	if (parent != null) {
	    page.setParent(parent);
	}

	page.getMetadata().setCreatedBy(user);

	// sending out email
	// from,password,to,subject,message

	Mailer.send("CookSystemsWiki@gmail.com", "bondstone", "CookSystemsWiki@gmail.com",
		"Wiki Page Added: " + page.getName(), getPageInformation(page));

	pageRepository.saveAndFlush(page);
	return pageMapper.entityToDto(page);
    }

    @Override
    public PageResponseDto updatePageTitle(Long id, PageRequestDto pageRequestDto) {
	User user = userRepository.findByCredentialsUsername(pageRequestDto.getCredentials().getUsername());
	userServiceMethods.checkUserCredentials(user, pageRequestDto.getCredentials());

	Page page = checkPage(id);
	page.setName(pageRequestDto.getName());
	page.getMetadata().setUpdatedBy(user);
	page.getMetadata().setUpdatedDate(LocalDate.now());
	pageRepository.saveAndFlush(page);
	return pageMapper.entityToDto(page);
    }

    @Override
    public PageResponseDto deletePage(Long id, Credentials credentials) {
	User user = userRepository.findByCredentialsUsername(credentials.getUsername());
	userServiceMethods.checkUserCredentials(user, credentials);

	Page page = checkPage(id);
	page.getMetadata().setDeletedFlag(true);
	page.getMetadata().setDeletedBy(user);
	page.getMetadata().setDeletedDate(LocalDate.now());

	// sending out email
	// from,password,to,subject,message

	Mailer.send("CookSystemsWiki@gmail.com", "bondstone", "CookSystemsWiki@gmail.com",
		"Wiki Page Deleted: " + page.getName(), getPageInformation(page));

	pageRepository.saveAndFlush(page);
	return pageMapper.entityToDto(page);
    }

    private Page checkPage(Long id) {
	Page pageResult = pageRepository.findByIdAndMetadataDeletedFlagFalse(id);
	if (pageResult == null) {
	    throw new PageNotFoundException();
	}
	return pageResult;
    }

    private String getPageInformation(Page page) {
	String result = "";

	result += "A page has been edited on the cook systems wiki\n" + "page title: " + page.getName() + "\n"
		+ "page type: " + page.getType() + "\n";

	if (page.getParent() != null) {
	    result += page.getParent().getType() + ": " + page.getParent().getName();
	}

	return result;
    }

}