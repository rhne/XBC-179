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


@Entity
@Table(name="T_ROOM")
public class RoomModel {

	private Long id;
	private String code;
	private String name;
	private Integer capacity;
	private Integer projector;
	private String notes;
	private OfficeModel officeModel;
	private Long idOffice;
	
	
	//AuditTrail////////////////////
		private Integer isActive;
			
		private Long createdBy;
		private AkunModel createdByUser;
		private Date createdOn;
				
		private Long modifiedBy;
		private AkunModel modifiedByUser;
		private Date modifiedOn;
	//AuditTrail/////////////////////
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_IDLE_NEWS")
	@TableGenerator(name="T_IDLE_NEWS", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="T_IDLE_NEWS_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="CODE")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="CAPACITY")
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	@Column(name="ANY_PROJECTOR")
	public Integer getProjector() {
		return projector;
	}
	public void setProjector(Integer projector) {
		this.projector = projector;
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
	public AkunModel getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(AkunModel createdByUser) {
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
	public AkunModel getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(AkunModel modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}
	
	
	@Column(name="MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_OFFICE",nullable=true, updatable=false, insertable=false)
	public OfficeModel getOfficeModel() {
		return officeModel;
	}
	public void setOfficeModel(OfficeModel officeModel) {
		this.officeModel = officeModel;
	}
	
	@Column
	(name="ID_OFFICE")
	public Long getIdOffice() {
		return idOffice;
	}
	public void setIdOffice(Long idOffice) {
		this.idOffice = idOffice;
	}
}
