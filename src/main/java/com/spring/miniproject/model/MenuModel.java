package com.spring.miniproject.model;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="M_MENU")
public class MenuModel {
	
	private Integer id;
	private String name, kode, controller;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_MENU")
	@TableGenerator(name="M_MENU", table="M_SEQUENCE",
						pkColumnName="SEQUENCE_NAME", pkColumnValue="M_MENU_ID",
						valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAMA")
	public String getNama() {
		return name;
	}
	
	public void setNama(String name) {
		this.name = name;
	}
	
	@Column(name="KODE")
	public String getKode() {
		return kode;
	}
	
	public void setKode(String kode) {
		this.kode = kode;
	}
	
	@Column(name="CONTROLLER")
	public String getController() {
		return controller;
	}
	
	public void setController(String controller) {
		this.controller = controller;
	}
	
	
}
