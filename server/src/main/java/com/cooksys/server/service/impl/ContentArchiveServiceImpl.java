package com.cooksys.server.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.server.dto.ContentArchiveRequestDto;
import com.cooksys.server.dto.ContentArchiveResponseDto;
import com.cooksys.server.dto.ContentResponseDto;
import com.cooksys.server.entity.Content;
import com.cooksys.server.entity.ContentArchive;
import com.cooksys.server.entity.Page;
import com.cooksys.server.entity.User;
import com.cooksys.server.errorhandling.ArchivedContentNotFoundException;
import com.cooksys.server.errorhandling.PageNotFoundException;
import com.cooksys.server.mailer.Mailer;
import com.cooksys.server.mapper.ContentArchiveMapper;
import com.cooksys.server.mapper.ContentMapper;
import com.cooksys.server.repository.ContentArchiveRepository;
import com.cooksys.server.repository.ContentRepository;
import com.cooksys.server.repository.PageRepository;
import com.cooksys.server.repository.UserRepository;
import com.cooksys.server.service.ContentArchiveService;

@Service
public class ContentArchiveServiceImpl implements ContentArchiveService {

    @Autowired
    private ContentArchiveRepository archiveRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private ContentArchiveMapper archiveMapper;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private ContentMapper contentMapper;

    private UserServiceMethods userServiceMethods = new UserServiceMethods();

    @Autowired
    public ContentArchiveServiceImpl(ContentArchiveRepository archiveRepository, UserRepository userRepository,
	    PageRepository pageRepository, ContentArchiveMapper archiveMapper, ContentRepository contentRepository,
	    ContentMapper contentMapper) {
	this.archiveRepository = archiveRepository;
	this.userRepository = userRepository;
	this.pageRepository = pageRepository;
	this.archiveMapper = archiveMapper;
	this.contentRepository = contentRepository;
	this.contentMapper = contentMapper;
    }

    @Override
    public List<ContentArchiveResponseDto> getArchivedContentByPageId(Long pageId,
	    ContentArchiveRequestDto archiveRequestDto) {
	// verifying credentials
	User user = userRepository.findByCredentialsUsername(archiveRequestDto.getCredentials().getUsername());
	userServiceMethods.checkUserCredentials(user, archiveRequestDto.getCredentials());

	Page page = pageRepository.findByIdAndMetadataDeletedFlagFalse(pageId);
	if (page == null) {
	    throw new PageNotFoundException();
	}

	List<ContentArchive> archivedContent = archiveRepository.findByPageId(page);

	if (archivedContent.isEmpty()) {
	    return null;
	}

	return archiveMapper.entitiesToDtos(archivedContent);
    }

    @Override
    public ContentResponseDto rollbackContent(Long archiveId, ContentArchiveRequestDto archiveRequestDto) {
	// verifying credentials
	User user = userRepository.findByCredentialsUsername(archiveRequestDto.getCredentials().getUsername());
	userServiceMethods.checkUserCredentials(user, archiveRequestDto.getCredentials());
	
	ContentArchive archivedContent;
	
	try {
	    archivedContent = archiveRepository.findById(archiveId).get();
	} catch (Exception exception) {
	    throw new ArchivedContentNotFoundException();
	}

	Page page = pageRepository.findByIdAndMetadataDeletedFlagFalse(archivedContent.getPageId().getId());

	Content content = page.getContent();
	ContentArchive contentToArchive = new ContentArchive();

	// creating archive object from content being removed to roll back
	contentToArchive.setArchivedDate(LocalDate.now());
	contentToArchive.setContent(content.getContent());
	contentToArchive.setContentId(content);
	contentToArchive.setPageId(page);
	contentToArchive.setUpdatedBy(user);

	// inserting rolled back content into the page
	content.setContent(archivedContent.getContent());

	// updating page metadata
	page.getMetadata().setUpdatedBy(user);
	page.getMetadata().setUpdatedDate(LocalDate.now());
	
	
	// sending out emails about content rollback

	    Mailer.send("CookSystemsWiki@gmail.com", "bondstone", "CookSystemsWiki@gmail.com", "Wiki Content Rollback",
		    getEmailMessage(contentToArchive.getContent(), content.getContent()));


	// deleting rolled back content from archive
	archiveRepository.deleteById(archiveId);

	// saving changes to database
	archiveRepository.saveAndFlush(contentToArchive);
	contentRepository.saveAndFlush(content);
	pageRepository.saveAndFlush(page);

	return contentMapper.entityToResponseDto(content);
    }
    
    public String getEmailMessage(String oldContent, String newContent) {
	String result = "";

	result += "Old Content being archived: \n\n" + oldContent + "\n\n\n"
		+ "New content being uploaded to wiki: \n\n" + newContent + "\n\n";

	return result;
    }

}
