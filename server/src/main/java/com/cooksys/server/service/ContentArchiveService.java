package com.cooksys.server.service;

import java.util.List;

import com.cooksys.server.dto.ContentArchiveRequestDto;
import com.cooksys.server.dto.ContentArchiveResponseDto;
import com.cooksys.server.dto.ContentResponseDto;

public interface ContentArchiveService {

    List<ContentArchiveResponseDto> getArchivedContentByPageId(Long pageId, ContentArchiveRequestDto archiveRequestDto);

    ContentResponseDto rollbackContent(Long archiveId, ContentArchiveRequestDto archiveRequestDto);


}
