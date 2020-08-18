package com.cooksys.server.service;

import com.cooksys.server.dto.ContentRequestDto;
import com.cooksys.server.dto.ContentResponseDto;

public interface ContentService {

//    SectionResponseDto addSection(String pageName, SectionRequestDto sectionRequestDto);

    ContentResponseDto updateContent(Long id, ContentRequestDto contentRequestDto);

//    SectionResponseDto deleteSection(Long id, SectionRequestDto sectionRequestDto);

}
