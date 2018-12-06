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
@Table(name="MA_MENU_AKSES")
public class MenuAksesModel {

	private Long id;
	
	private Long idMenu;
	private MenuModel menuModel;
	
	private Long idRole;
	private RoleModel roleModel;
	
	
	//AuditTrail////////////////////
			
		private Long createdBy;
		private MenuAksesModel createdByUser;
		private Date createdOn;

	//AuditTrail/////////////////////
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MA_MENU_AKSES")
	@TableGenerator(name="MA_MENU_AKSES", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="MA_MENU_AKSES_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="ID_MENU")
	public Long getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_MENU", nullable=true, updatable=false, insertable=false)
	public MenuModel getMenuModel() {
		return menuModel;
	}
	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
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
	
	@Column(name="CREATED_BY")
	public Long getcreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@ManyToOne
	@JoinColumn(name="CREATED_BY",nullable=true, updatable=false, insertable=false)
	public MenuAksesModel getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(MenuAksesModel createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	@Column(name="CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
		
}
