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

@Entity
@Table(name="M_MENU")
public class MenuModel {
	
	private Long id, parent, createdBy, modifiedBy;
	private String kode, title, description, imgurl, menuurl;
	private Integer active, order;
	private LocalDateTime createdOn, modifiedOn;
	
	//Join Column
	private AkunModel createdByUser;
	private AkunModel modifiedByUser;
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_MENU")
	@TableGenerator(name="M_MENU", table="S_SEQUENCE",
						pkColumnName="SEQUENCE_NAME", pkColumnValue="M_MENU_ID",
						valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="MENU_PARENT")
	public Long getParent() {
		return parent;
	}
	public void setParent(Long parent) {
		this.parent = parent;
	}
	@Column(name="KODE")
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="IMAGE_URL")
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	@Column(name="MENU_URL")
	public String getMenuurl() {
		return menuurl;
	}
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
	@Column(name="ACTIVE")
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	@Column(name="MENU_ORDER")
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	@CreationTimestamp
	@Column(name="CREATED_ON")
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	@UpdateTimestamp
	@Column(name="MODIFIED_ON")
	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	@ManyToOne
	@JoinColumn(name="CREATED_BY",nullable=true, updatable=false, insertable=false)
	public AkunModel getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(AkunModel createdByUser) {
		this.createdByUser = createdByUser;
	}
	@ManyToOne
	@JoinColumn(name="MODIFIED_BY",nullable=true, updatable=false, insertable=false)
	public AkunModel getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(AkunModel modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}
	@Column(name="CREATED_BY")
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	@Column(name="MODIFIED_BY")
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
		
}
