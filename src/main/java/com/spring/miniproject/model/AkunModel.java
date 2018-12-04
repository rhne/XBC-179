package com.spring.miniproject.model;

import java.time.LocalDateTime; 

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

import com.spring.miniproject.model.RoleModel;

@Entity
@Table(name="U_USER")
public class AkunModel {

	private Long id;
	private String name;
	private String password;
	
	private Long idRole;
	private RoleModel roleModel;
	
	private Integer mobileFlag;
	private Long mobileToken;
	
	//AuditTrail////////////////////
		private Integer isActive;
			
		private Long createdBy;
		private AkunModel createdByUser;
		private LocalDateTime createdOn;
				
		private Long modifiedBy;
		private AkunModel modifiedByUser;
		private LocalDateTime modifiedOn;
	//AuditTrail/////////////////////
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="U_USER")
	@TableGenerator(name="U_USER", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="U_USER_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="USERNAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="ID_ROLE")
	public Long getIdRole() {
		return idRole;
	}
	
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_ROLE", nullable=true, updatable=false, insertable=false)
	public RoleModel getRoleModel() {
		return roleModel;
	}
	
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
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
	
	@CreationTimestamp
	@Column(name="CREATED_ON")
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
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
	
	@UpdateTimestamp
	@Column(name="MODIFIED_ON")
	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	@Column(name="MOBILE_FLAG")
	public Integer getMobileFlag() {
		return mobileFlag;
	}
	public void setMobileFlag(Integer mobileFlag) {
		this.mobileFlag = mobileFlag;
	}
	
	@Column(name="MOBILE_TOKEN")
	public Long getMobileToken() {
		return mobileToken;
	}
	public void setMobileToken(Long mobileToken) {
		this.mobileToken = mobileToken;
	}
}
