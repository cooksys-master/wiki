package com.cooksys.server.dto;

public class ContentResponseDto {

    private Long id;
    private String content;
    

    public ContentResponseDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
	return "ContentResponseDto [id=" + id + ", content=" + content + "]";
    }



}
