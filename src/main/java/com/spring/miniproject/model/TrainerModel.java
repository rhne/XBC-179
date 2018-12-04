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
@Table(name="M_TRAINER")
public class TrainerModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="M_TRAINER")
	@TableGenerator(name="M_TRAINER", table="S_SEQUENCE", pkColumnName="SEQUENCE_NAME", pkColumnValue="ID_SEQ_TRAINER", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	@Column(name="ID")
	private Integer idTrainer;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="NOTES")
	private String notes;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@CreationTimestamp
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;
	
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
	@UpdateTimestamp
	@Column(name="MODIFIED_ON")
	private LocalDateTime modifiedOn;
	
	@Column(name="ACTIVE")
	private Integer active;

	public Integer getIdTrainer() {
		return idTrainer;
	}

	public void setIdTrainer(Integer idTrainer) {
		this.idTrainer = idTrainer;
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
