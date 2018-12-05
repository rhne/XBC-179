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
@Table(name="M_TECHNOLOGY")
public class TechnologyModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="M_TECHNOLOGY")
	@TableGenerator(name="M_TECHNOLOGY", table="S_SEQUENCE", pkColumnName="SEQUENCE_NAME", pkColumnValue="ID_SEQ_TECH", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	@Column(name="ID")
	private Integer idTech;
	
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
	
	@Column(name="ID_TRAINER")
	private Integer idTrainer;
	
	@ManyToOne
	@JoinColumn(name="ID_TRAINER", nullable=true, updatable=false,insertable=false)
	private TrainerModel trainerModel;
	
	
	public Integer getIdTech() {
		return idTech;
	}
	public void setIdTech(Integer idTech) {
		this.idTech = idTech;
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
	public Integer getIdTrainer() {
		return idTrainer;
	}
	public void setIdTrainer(Integer idTrainer) {
		this.idTrainer = idTrainer;
	}
	public TrainerModel getTrainerModel() {
		return trainerModel;
	}
	public void setTrainerModel(TrainerModel trainerModel) {
		this.trainerModel = trainerModel;
	}
	
		
}
