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

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name="T_BOOTCAMP_TEST_TYPE")
public class BootcampTestTypeModel {

	private Long id;
	private String name;
	private String notes;
	
	//AuditTrail////////////////////
		private Integer isActive;
			
		private Long createdBy;
		private BootcampTestTypeModel createdByUser;
		private Date createdOn;
				
		private Long modifiedBy;
		private BootcampTestTypeModel modifiedByUser;
		private Date modifiedOn;
	//AuditTrail/////////////////////
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_BOOTCAMP_TEST_TYPE")
	@TableGenerator(name="T_BOOTCAMP_TEST_TYPE", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="T_BOOTCAMP_TEST_TYPE_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="NAMA")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Column(name="IS_ACTIVE")
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	@Column(name="CREATED_BY")
	public Long getcreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@ManyToOne
	@JoinColumn(name="CREATED_BY",nullable=true, updatable=false, insertable=false)
	public BootcampTestTypeModel getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(BootcampTestTypeModel createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	@Column(name="CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name="MODIFIED_BY")
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@ManyToOne
	@JoinColumn(name="MODIFIED_BY",nullable=true, updatable=false, insertable=false)
	public BootcampTestTypeModel getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(BootcampTestTypeModel modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}
	
	@Column(name="MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
}
