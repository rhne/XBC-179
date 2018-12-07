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

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "A_ASSIGNMENT")
public class AssignmentModel {

	private Long id;
	private String title;
	private Date startDate;
	private Date endDate;
	private String description;
	private Date realizationDate;
	private String notes;
	private Integer isHold;
	private Integer isDone;
	
	private BiodataModel biodataModel;
	private Long testId;
	
	// AuditTrail////////////////////
	private Long createdBy;
	private Date createdOn;
	private Integer modifiedBy;
	private Date modifiedOn;
	private Long deletedBy;
	private Date deletedOn;
	private Integer isDelete;
	// AuditTrail/////////////////////

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "A_ASSIGNMENT")
	@TableGenerator(name = "A_ASSIGNMENT", table = "S_SEQUENCE", pkColumnName = "SEQUENCE_NAME", pkColumnValue = "A_ASSIGNMENT_ID", valueColumnName = "SEQUENCE_VALUE", allocationSize = 1, initialValue = 0)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "BIODATA_ID")
	public Long getTestId() {
		return testId;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "REALIZATION_DATE")
	public Date getRealizationDate() {
		return realizationDate;
	}
	public void setRealizationDate(Date realizationDate) {
		this.realizationDate = realizationDate;
	}

	@Column(name = "NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "IS_HOLD")
	public Integer getIsHold() {
		return isHold;
	}
	public void setIsHold(Integer isHold) {
		this.isHold = isHold;
	}

	@Column(name = "IS_DONE")
	public Integer getIsDone() {
		return isDone;
	}
	public void setIsDone(Integer isDone) {
		this.isDone = isDone;
	}

	@CreatedBy
	@Column(name = "CREATED_BY")
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@CreationTimestamp
	@Column(name = "CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@LastModifiedBy
	@Column(name = "MODIFIED_BY")
	public Integer getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@LastModifiedDate
	@Column(name = "MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Column(name = "DELETED_BY")
	public Long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	@Column(name = "DELETED_ON")
	public Date getDeletedOn() {
		return deletedOn;
	}
	public void setDeletedOn(Date deletedOn) {
		this.deletedOn = deletedOn;
	}

	@Column(name = "IS_DELETE")
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	@ManyToOne
	@JoinColumn(name = "BIODATA_ID", nullable = true, updatable = false, insertable = false)
	public BiodataModel getBiodataModel() {
		return biodataModel;
	}
	public void setBiodataModel(BiodataModel biodataModel) {
		this.biodataModel = biodataModel;
	}	
}
