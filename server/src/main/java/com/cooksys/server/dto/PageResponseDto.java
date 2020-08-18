package com.cooksys.server.dto;

import java.util.List;

public class PageResponseDto {

    private Long id;
    private String name;
    private String type;
    private ContentResponseDto content;
    private List<PageSimpleResponseDto> subPageList;
    private MetadataDto metadata;
    private Long parentId;


    
    public PageResponseDto() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ContentResponseDto getContent() {
        return this.content;
    }

    public void setContent(ContentResponseDto content) {
        this.content = content;
    }

    public List<PageSimpleResponseDto> getSubPageList() {
        return this.subPageList;
    }

    public void setSubPageList(List<PageSimpleResponseDto> subPageList) {
        this.subPageList = subPageList;
    }

    public MetadataDto getMetadata() {
        return this.metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
   

}
