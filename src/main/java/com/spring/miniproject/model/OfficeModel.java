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

import com.spring.miniproject.model.RoleModel;

@Entity
@Table(name="T_OFFICE")
public class OfficeModel {

	private Integer id;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String notes;
	
	//AuditTrail////////////////////
		private Integer isActive;
			
		private Integer createdBy;
		private OfficeModel createdByUser;
		private Date createdOn;
				
		private Integer modifiedBy;
		private OfficeModel modifiedByUser;
		private Date modifiedOn;
	//AuditTrail/////////////////////
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_OFFICE")
	@TableGenerator(name="T_OFFICE", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="T_OFFICE_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAMA")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="PHONE")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Column(name="IS_DELETE")
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	@Column(name="CREATED_BY")
	public Integer getcreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	@ManyToOne
	@JoinColumn(name="CREATED_BY",nullable=true, updatable=false, insertable=false)
	public OfficeModel getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(OfficeModel createdByUser) {
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
	public Integer getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@ManyToOne
	@JoinColumn(name="MODIFIED_BY",nullable=true, updatable=false, insertable=false)
	public OfficeModel getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(OfficeModel modifiedByUser) {
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
