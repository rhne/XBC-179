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


@Entity
@Table(name="M_CLAZZ")
public class ClazzModel {

	@Id
	@Column(name="ID_CLAZZ")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_CLAZZ")
	@TableGenerator(name="M_CLAZZ", table="S_SEQUENCE", pkColumnName="SEQUENCE_NAME", pkColumnValue="ID_CLAZZ", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	private Long clazzId;
	
	@Column(name="ID_BATCH")
	private Long batchId;
	
	@Column(name="ID_BIODATA")
	private Long biodataId;
	
	@Column(name="CREATED_BY")
	private Long createdBy;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="IS_DELETED")
	private  Integer isDeleted;

	public Long getClazzId() {
		return clazzId;
	}

	public void setClazzId(Long clazzId) {
		this.clazzId = clazzId;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Long getBiodataId() {
		return biodataId;
	}

	public void setBiodataId(Long biodataId) {
		this.biodataId = biodataId;
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
	
	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	//RELATIONSHIP TABLE

	@ManyToOne
	@JoinColumn(name="ID_BATCH", insertable=false, updatable=false)
	private BatchModel batchModel;
	
	@ManyToOne
	@JoinColumn(name="ID_BIODATA", insertable=false, updatable=false)
	private BiodataModel biodataModel;

	public BatchModel getBatchModel() {
		return batchModel;
	}

	public void setBatchModel(BatchModel batchModel) {
		this.batchModel = batchModel;
	}

	public BiodataModel getBiodataModel() {
		return biodataModel;
	}

	public void setBiodataModel(BiodataModel biodataModel) {
		this.biodataModel = biodataModel;
	}
	
	
}
