package com.spring.miniproject.model;

import java.time.LocalDateTime;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.spring.miniproject.model.RoleModel;

@Entity
@Table(name="T_CATEGORY")
public class CategoryModel {

	private Long id;
	private String code;
	private String name;
	private String description;
	
	//AuditTrail////////////////////
		private Integer isActive;
			
		private Long createdBy;
		private CategoryModel createdByUser;
		private LocalDateTime createdOn;
				
		private Long modifiedBy;
		private CategoryModel modifiedByUser;
		private LocalDateTime modifiedOn;
	//AuditTrail/////////////////////
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_CATEGORY")
	@TableGenerator(name="T_CATEGORY", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="T_CATEGORY_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="IS_DELETE")
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
	public CategoryModel getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(CategoryModel createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	@CreationTimestamp
	@Column(name="CREATED_ON")
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
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
	public CategoryModel getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(CategoryModel modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}
	
	@UpdateTimestamp
	@Column(name="MODIFIED_ON")
	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
}
