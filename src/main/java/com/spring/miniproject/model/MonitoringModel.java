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
@Table(name = "M_MONITORING")
public class MonitoringModel {

	private Long id;
	private Date idleDate;
	private String lastProject;
	private String idleReason;
	private Date placementDate;
	private String placementAt;
	private String notes;

	private BiodataModel biodataModel;
	private Long testId;
	
	private AkunModel createdByUser;
	private AkunModel modifiedByUser;

	// AuditTrail////////////////////
	private Long createdBy;
	private Date createdOn;
	private Long modifiedBy;
	private Date modifiedOn;
	private Long deletedBy;
	private Date deletedOn;
	private Integer isDelete;
	// AuditTrail/////////////////////

	/* Auto Increment */
	@Id
	@Column(name = "ID", nullable = false, length = 11)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "M_MONITORING")
	@TableGenerator(name = "M_MONITORING", table = "S_SEQUENCE", pkColumnName = "SEQUENCE_NAME", pkColumnValue = "M_MONITORING_ID", valueColumnName = "SEQUENCE_VALUE", allocationSize = 1, initialValue = 0)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "BIODATA_ID", nullable = false, length = 11)
	public Long getTestId() {
		return testId;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}

	@Column(name = "IDLE_DATE", nullable = false)
	public Date getIdleDate() {
		return idleDate;
	}
	public void setIdleDate(Date idleDate) {
		this.idleDate = idleDate;
	}

	@Column(name = "LAST_PROJECT", length = 50)
	public String getLastProject() {
		return lastProject;
	}
	public void setLastProject(String lastProject) {
		this.lastProject = lastProject;
	}

	@Column(name = "IDLE_REASON", length = 255)
	public String getIdleReason() {
		return idleReason;
	}
	public void setIdleReason(String idleReason) {
		this.idleReason = idleReason;
	}

	@Column(name = "PLACEMENT_DATE", nullable = false)
	public Date getPlacementDate() {
		return placementDate;
	}
	public void setPlacementDate(Date placementDate) {
		this.placementDate = placementDate;
	}

	@Column(name = "PLACEMENT_AT", length = 50)
	public String getPlacementAt() {
		return placementAt;
	}
	public void setPlacementAt(String placementAt) {
		this.placementAt = placementAt;
	}

	@Column(name = "NOTES", length = 255)
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/* User Login ID */
	@CreatedBy
	@Column(name = "CREATED_BY", nullable = false, length = 11)
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@CreationTimestamp
	@Column(name = "CREATED_ON", nullable = false)
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/* User Login ID */
	@LastModifiedBy
	@Column(name = "MODIFIED_BY", length = 11)
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
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

	/* User Login ID */
	@Column(name = "DELETED_BY", length = 11)
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

	@Column(name = "IS_DELETE", nullable = false)
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	/* Biodata Join Table */
	@ManyToOne
	@JoinColumn(name = "BIODATA_ID", nullable = false, updatable = false, insertable = false)
	public BiodataModel getBiodataModel() {
		return biodataModel;
	}
	public void setBiodataModel(BiodataModel biodataModel) {
		this.biodataModel = biodataModel;
	}
	
	/* Created By Join Table Akun */
	@ManyToOne
	@JoinColumn(name="CREATED_BY",nullable=false, updatable=false, insertable=false)
	public AkunModel getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(AkunModel createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	/* Modified By Join Table Akun */
	@ManyToOne
	@JoinColumn(name="MODIFIED_BY",nullable=false, updatable=false, insertable=false)
	public AkunModel getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(AkunModel modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}
}