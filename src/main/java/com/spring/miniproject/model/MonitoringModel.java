package com.spring.miniproject.model;

import java.time.LocalDate;

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
	private LocalDate idleDate;
	
	@Column(name="LAST_PROJECT")
	private String lastProject;
	
	@Column(name="IDLE_REASON")
	private String idleReason;
	
	@Column(name="PLACEMENT_DATE")
	private LocalDate placementDate;
	
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
		private LocalDate createdOn;
		
		@LastModifiedBy
		@Column(name="MODIFIED_BY")
		private Integer modifiedBy;
		
		@LastModifiedDate
		@Column(name="MODIFIED_ON")
		private LocalDate modifiedOn;
		
		
		@Column(name="DELETED_BY")
		private Long deletedBy;
		
		@Column(name="DELETED_ON")
		private LocalDate deletedOn;
		
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

		public Long getBiodataId() {
			return testId;
		}

		public void setBiodataId(Long testId) {
			this.testId = testId;
		}

		public LocalDate getIdleDate() {
			return idleDate;
		}

		public void setIdleDate(LocalDate idleDate) {
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

		public LocalDate getPlacementDate() {
			return placementDate;
		}

		public void setPlacementDate(LocalDate placementDate) {
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

		public LocalDate getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(LocalDate createdOn) {
			this.createdOn = createdOn;
		}

		public Integer getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(Integer modifiedBy) {
			this.modifiedBy = modifiedBy;
		}

		public LocalDate getModifiedOn() {
			return modifiedOn;
		}

		public void setModifiedOn(LocalDate modifiedOn) {
			this.modifiedOn = modifiedOn;
		}

		public Long getDeletedBy() {
			return deletedBy;
		}

		public void setDeletedBy(Long deletedBy) {
			this.deletedBy = deletedBy;
		}

		public LocalDate getDeletedOn() {
			return deletedOn;
		}

		public void setDeletedOn(LocalDate deletedOn) {
			this.deletedOn = deletedOn;
		}

		public Integer getIsDelete() {
			return isDelete;
		}

		public void setIsDelete(Integer isDelete) {
			this.isDelete = isDelete;
		}
		
		
	
	
}
