package com.spring.miniproject.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="M_TESTIMONY")
public class TestimonyModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="M_TESTIMONY")
	@TableGenerator(name="M_TESTIMONY", table="S_SEQUENCE", pkColumnName="SEQUENCE_NAME", pkColumnValue="ID_TESTIMONY", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	@Column(name="ID")
	private Long idTestimony;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@CreationTimestamp
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;
	
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
	@UpdateTimestamp
	@Column(name="MODIFIED_ON")
	private LocalDateTime modifiedOn;
	
	@Column(name="DELETED_BY")
	private String deletedBy;
	
	@Column(name="DELETED_ON")
	private Date deletedOn;
	
	@Column(name="IS_DELETED")
	private Integer isDeleted;

	public Long getIdTestimony() {
		return idTestimony;
	}

	public void setIdTestimony(Long idTestimony) {
		this.idTestimony = idTestimony;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}
	
	
	
}
