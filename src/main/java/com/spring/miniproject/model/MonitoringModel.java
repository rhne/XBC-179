package com.spring.miniproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "M_MONITORING")
public class MonitoringModel {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_MONITORING")
	@TableGenerator(name="M_MONITORING", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="M_MONITORING_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	private Long id;
	
	@Column(name="BIODATA_ID")
	private Long testId;
	
	@Column(name="IDLE_DATE")
	private Date idleDate;
	
	@Column(name="LAST_PROJECT")
	private String lastProject;
	
	@Column(name="IDLE_REASON")
	private String idleReason;
	
	@Column(name="PLACEMENT_DATE")
	private Date placementDate;
	
	@Column(name="PLACEMENT_AT")
	private String placementAt;
	
	@Column(name="NOTES")
	private String notes;
	
	// AuditTrail////////////////////
		@CreatedBy
		@Column(name="CREATED_BY")
		private Long createdBy;
		
		@CreatedDate
		@Column(name="CREATED_ON")
		private Date createdOn;
		
		@LastModifiedBy
		@Column(name="MODIFIED_BY")
		private Integer modifiedBy;
		
		@LastModifiedDate
		@Column(name="MODIFIED_ON")
		private Date modifiedOn;
		
		
		@Column(name="DELETED_BY")
		private Long deletedBy;
		
		@Column(name="DELETED_ON")
		private Date deletedOn;
		
		@Column(name="IS_DELETE")
		private Integer isDelete;		
		/*private AkunModel createdByUser;
		private AkunModel modifiedByUser;*/
		// AuditTrail/////////////////////
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getTestId() {
			return testId;
		}

		public void setTestId(Long testId) {
			this.testId = testId;
		}

		public Date getIdleDate() {
			return idleDate;
		}

		public void setIdleDate(Date idleDate) {
			this.idleDate = idleDate;
		}

		public String getLastProject() {
			return lastProject;
		}

		public void setLastProject(String lastProject) {
			this.lastProject = lastProject;
		}

		public String getIdleReason() {
			return idleReason;
		}

		public void setIdleReason(String idleReason) {
			this.idleReason = idleReason;
		}

		public Date getPlacementDate() {
			return placementDate;
		}

		public void setPlacementDate(Date placementDate) {
			this.placementDate = placementDate;
		}

		public String getPlacementAt() {
			return placementAt;
		}

		public void setPlacementAt(String placementAt) {
			this.placementAt = placementAt;
		}

		public String getNotes() {
			return notes;
		}

		public void setNotes(String notes) {
			this.notes = notes;
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

		public Integer getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(Integer modifiedBy) {
			this.modifiedBy = modifiedBy;
		}

		public Date getModifiedOn() {
			return modifiedOn;
		}

		public void setModifiedOn(Date modifiedOn) {
			this.modifiedOn = modifiedOn;
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

		public Integer getIsDelete() {
			return isDelete;
		}

		public void setIsDelete(Integer isDelete) {
			this.isDelete = isDelete;
		}
		
		
}
