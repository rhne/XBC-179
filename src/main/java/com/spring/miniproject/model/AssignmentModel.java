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
@Table(name = "A_ASSIGNMENT")
public class AssignmentModel {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="A_ASSIGNMENT")
	@TableGenerator(name="A_ASSIGNMENT", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="A_ASSIGNMENT_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	private Long id;
	
	@Column(name="BIODATA_ID")
	private Long testId;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="START_DATE")
	private LocalDate startDate;
	
	@Column(name="END_DATE")
	private LocalDate endDate;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="REALIZATION_DATE")
	private LocalDate realizationDate;
	
	@Column(name="NOTES")
	private String notes;
	
	@Column(name="IS_HOLD")
	private Integer isHold;
	
	@Column(name="IS_DONE")
	private Integer isDone;
	
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

		public Long getTestId() {
			return testId;
		}

		public void setTestId(Long testId) {
			this.testId = testId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		public LocalDate getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public LocalDate getRealizationDate() {
			return realizationDate;
		}

		public void setRealizationDate(LocalDate realizationDate) {
			this.realizationDate = realizationDate;
		}

		public String getNotes() {
			return notes;
		}

		public void setNotes(String notes) {
			this.notes = notes;
		}

		public Integer getIsHold() {
			return isHold;
		}

		public void setIsHold(Integer isHold) {
			this.isHold = isHold;
		}

		public Integer getIsDone() {
			return isDone;
		}

		public void setIsDone(Integer isDone) {
			this.isDone = isDone;
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
