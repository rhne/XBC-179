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

import com.spring.miniproject.model.RoleModel;

@Entity
@Table(name="U_USER")
public class AkunModel {

	private Integer id;
	private String name;
	private String password;
	
	private Integer idRole;
	private RoleModel roleModel;
	
	//AuditTrail////////////////////
		private Integer isActive;
			
		private Integer createdBy;
		private AkunModel createdByUser;
		private Date createdOn;
				
		private Integer modifiedBy;
		private AkunModel modifiedByUser;
		private Date modifiedOn;
	//AuditTrail/////////////////////
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="U_USER")
	@TableGenerator(name="U_USER", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="U_USER_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAMA")
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
	public Integer getIdRole() {
		return idRole;
	}
	
	public void setIdRole(Integer idRole) {
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
	
	@Column(name="IS_DELETE")
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	@Column(name="CREATED_BY")
	public Integer getcreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
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
	public Integer getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Integer modifiedBy) {
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
}
