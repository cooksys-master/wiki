package com.cooksys.server.dto;

import java.time.LocalDate;

public class ContentArchiveResponseDto {
    
    private Long id;
    private Long contentId;
    private String content;
    private Long pageId;
    private String pageName;
    private String updatedBy;
    private LocalDate archivedDate;
    
    
    public ContentArchiveResponseDto() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getContentId() {
        return contentId;
    }


    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public Long getPageId() {
        return pageId;
    }


    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }


    public String getPageName() {
        return pageName;
    }


    public void setPageName(String pageName) {
        this.pageName = pageName;
    }


    public String getUpdatedBy() {
        return updatedBy;
    }


    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    
    public LocalDate getArchivedDate() {
        return archivedDate;
    }


    public void setArchivedDate(LocalDate archivedDate) {
        this.archivedDate = archivedDate;
    }
}
