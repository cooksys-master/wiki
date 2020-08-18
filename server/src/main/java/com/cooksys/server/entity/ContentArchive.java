package com.cooksys.server.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ContentArchive
 */
@Entity
@Table(name = "content_archive")
public class ContentArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content contentId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page pageId;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private User updatedBy;
    
    @Column(name = "archived_date")
    private LocalDate archivedDate;

    public ContentArchive() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Content getContentId() {
        return contentId;
    }

    public void setContentId(Content contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Page getPageId() {
        return pageId;
    }

    public void setPageId(Page pageId) {
        this.pageId = pageId;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getArchivedDate() {
        return archivedDate;
    }

    public void setArchivedDate(LocalDate archivedDate) {
        this.archivedDate = archivedDate;
    }

    @Override
    public String toString() {
	return "ContentArchive [id=" + id + ", contentId=" + contentId.getId() + ", content=" + content + ", pageId=" + pageId.getId()
		+ ", updatedBy=" + updatedBy.getCredentials().getUsername() + ", archivedDate=" + archivedDate + "]";
    }
    
    

}