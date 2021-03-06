package com.spring.miniproject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="T_VERSION")
public class VersionModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_VERSION")
	@TableGenerator(name="T_VERSION", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="T_VERSION_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	private Long id;
	@Column(name="VERSION", nullable=false)
	private Integer version;
	@Column(name="CREATED_ON", nullable=false)
	private Date createdOn;
	@Column(name="MODIFIED_ON")
	private Date modifiedOn;
	@Column(name="DELETED_ON")
	private Date deletedOn;
	@Column(name="IS_DELETE", nullable=false)
	private Integer isDelete;
	
	@OneToMany(mappedBy="version")
	private List<VersionDetailModel> versionDetails;
	
	//Join Column
	@ManyToOne
	@JoinColumn(name="CREATED_BY", nullable=false)
	private AkunModel createdBy;
	@ManyToOne
	@JoinColumn(name="MODIFIED_BY")
	private AkunModel modifiedBy;
	@ManyToOne
	@JoinColumn(name="DELETED_BY")
	private AkunModel deletedBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
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
	public List<VersionDetailModel> getVersionDetails() {
		return versionDetails;
	}
	public void setVersionDetails(List<VersionDetailModel> versionDetails) {
		this.versionDetails = versionDetails;
	}
	public AkunModel getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(AkunModel createdBy) {
		this.createdBy = createdBy;
	}
	public AkunModel getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(AkunModel modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public AkunModel getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(AkunModel deletedBy) {
		this.deletedBy = deletedBy;
	}
}
