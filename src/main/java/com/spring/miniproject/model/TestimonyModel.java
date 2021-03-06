package com.spring.miniproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

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
	private Long createdBy;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="MODIFIED_BY")
	private Long modifiedBy;
	
	@Column(name="MODIFIED_ON")
	private Date modifiedOn;
	
	@Column(name="DELETED_BY")
	private Long deletedBy;
	
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}
	
	@ManyToOne
	@JoinColumn(name="CREATED_BY", insertable=false, updatable=false)
	private AkunModel akunModel;

	public AkunModel getAkunModel() {
		return akunModel;
	}

	public void setAkunModel(AkunModel akunModel) {
		this.akunModel = akunModel;
	}
	
	
	
}
