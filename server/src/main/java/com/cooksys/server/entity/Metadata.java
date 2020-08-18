package com.cooksys.server.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Metadata {

    // Default Value to todays date
    // current_date
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Column(name = "deleted_date")
    private LocalDate deletedDate;

    // Setting this to false for default value
    @Column(name = "deleted_flag", nullable = false)
    private Boolean deletedFlag = false;

    @ManyToOne
    @JoinColumn(name = "deleted_by")
    private User deletedBy;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private User updatedBy;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public Metadata() {
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocalDate getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(LocalDate deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Boolean getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(Boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public User getDeletedBy() {
        return this.deletedBy;
    }

    public void setDeletedBy(User deletedBy) {
        this.deletedBy = deletedBy;
    }

    public User getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
	return "Metadata [createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", deletedDate=" + deletedDate
		+ ", deletedFlag=" + deletedFlag + ", deletedBy=" + deletedBy + ", updatedBy=" + updatedBy
		+ ", createdBy=" + createdBy + "]";
    }
    
    

}
