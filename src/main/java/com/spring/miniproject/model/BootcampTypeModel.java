package com.spring.miniproject.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="M_BOOTCAMP")
public class BootcampTypeModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="M_BOOTCAMP")
	@Column(name="ID_BOOTCAMP")
	@TableGenerator(name="M_BOOTCAMP", table="S_SEQUENCE",
	pkColumnName="SEQUENCE_NAME", pkColumnValue="ID_BOOTCAMP",
	valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	private Long idBootcamp;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="NOTES")
	private String notes;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_ON")
	@CreationTimestamp
	private LocalDateTime createdOn;
	
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name="MODIFIED_ON")
	@UpdateTimestamp
	private LocalDateTime modifiedOn;
	
	@Column(name="ACTIVE")
	private Integer active;

	public Long getIdBootcamp() {
		return idBootcamp;
	}

	public void setIdBootcamp(Long idBootcamp) {
		this.idBootcamp = idBootcamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
	
	
}
