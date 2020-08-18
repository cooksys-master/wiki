
package com.cooksys.server.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.server.dto.ContentRequestDto;
import com.cooksys.server.dto.ContentResponseDto;
import com.cooksys.server.entity.Content;
import com.cooksys.server.entity.ContentArchive;
import com.cooksys.server.entity.Metadata;
import com.cooksys.server.entity.Page;
import com.cooksys.server.entity.User;
import com.cooksys.server.errorhandling.PageNotFoundException;
import com.cooksys.server.errorhandling.UserNotFoundException;
import com.cooksys.server.mailer.Mailer;
import com.cooksys.server.mapper.ContentMapper;
import com.cooksys.server.repository.ContentArchiveRepository;
import com.cooksys.server.repository.ContentRepository;
import com.cooksys.server.repository.PageRepository;
import com.cooksys.server.repository.UserRepository;
import com.cooksys.server.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContentArchiveRepository contentArchiveRepository;

    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository, ContentMapper contentMapper,
	    PageRepository pageRepository, UserRepository userRepository,
	    ContentArchiveRepository contentArchiveRepository) {
	super();
	this.contentRepository = contentRepository;
	this.contentMapper = contentMapper;
	this.pageRepository = pageRepository;
	this.userRepository = userRepository;
	this.contentArchiveRepository = contentArchiveRepository;
    }

    @Override
    public ContentResponseDto updateContent(Long id, ContentRequestDto contentRequestDto) {

	User user = userRepository
		.findByCredentialsUsernameAndMetadataDeletedFlagFalse(contentRequestDto.getCredentials().getUsername());
	if (user == null) {
	    throw new UserNotFoundException();
	}

	Page page = checkPage(id);
	Content contentToUpdate = page.getContent();

	ContentArchive contentToArchive = new ContentArchive();

	// Archiving current content
	// only archive content if its length is > 0
	if (contentToUpdate.getContent().length() > 0) {
	    contentToArchive.setContentId(contentToUpdate);
	    contentToArchive.setContent(contentToUpdate.getContent());
	    contentToArchive.setPageId(page);
	    contentToArchive.setUpdatedBy(user);
	    contentToArchive.setArchivedDate(LocalDate.now());
	    contentArchiveRepository.saveAndFlush(contentToArchive);
	}
	// updating content
	contentToUpdate.setContent(contentRequestDto.getContent());

	// updating metadata
	Metadata pageMetadata = page.getMetadata();

	pageMetadata.setUpdatedBy(user);
	pageMetadata.setUpdatedDate(LocalDate.now());

	// sending out email about the updates
	// from,password,to,subject,message

	Mailer.send("CookSystemsWiki@gmail.com", "bondstone", "CookSystemsWiki@gmail.com", "Wiki Content Update",
		getEmailMessage(contentToArchive.getContent(), contentToUpdate.getContent()));

	// saving changes to database
	contentRepository.saveAndFlush(contentToUpdate);
	pageRepository.saveAndFlush(page);

	return contentMapper.entityToResponseDto(contentToUpdate);
    }

    private Page checkPage(Long id) {
	Page pageResult = pageRepository.findByIdAndMetadataDeletedFlagFalse(id);
	if (pageResult == null) {
	    throw new PageNotFoundException();
	}
	return pageResult;
    }

    public String getEmailMessage(String oldContent, String newContent) {
	String result = "";

	result += "Old Content being archived: \n\n" + oldContent + "\n\n\n"
		+ "New content being uploaded to wiki: \n\n" + newContent + "\n\n";

	return result;
    }

}
