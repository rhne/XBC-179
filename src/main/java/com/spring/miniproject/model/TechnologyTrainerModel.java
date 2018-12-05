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

@Entity
@Table(name="M_TECH_TRAINER")
public class TechnologyTrainerModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="M_TECH_TRAINER")
	@TableGenerator(name="M_TECH_TRAINER", table="S_SEQUENCE", pkColumnName="SEQUENCE_NAME", pkColumnValue="ID_TECH_TRAINER", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	private Integer idTechTrainer;
	
	@Column(name="TECHNOLOGY_ID")
	private Integer technologyId;
	
	@Column(name="TRAINER_ID")
	private Integer trainerId;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@CreationTimestamp
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;

	public Integer getIdTechTrainer() {
		return idTechTrainer;
	}

	public void setIdTechTrainer(Integer idTechTrainer) {
		this.idTechTrainer = idTechTrainer;
	}

	public Integer getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
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
	
	
}
