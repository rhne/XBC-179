package com.spring.miniproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="T_FEEDBACK")
public class FeedbackModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_FEEDBACK")
	@TableGenerator(name="T_FEEDBACK", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="T_FEEDBACK_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	private Long id;
	private Long testId;
	private Long versionId;
	@Column(name="JSON_FEEDBACK", length=5000)
	private String jsonFeedback;
	private Date createdOn;
	private Date deletedOn;
	private Integer isDelete;
	
	
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
	public Long getVersionId() {
		return versionId;
	}
	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	public String getJsonFeedback() {
		return jsonFeedback;
	}
	public void setJsonFeedback(String jsonFeedback) {
		this.jsonFeedback = jsonFeedback;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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
