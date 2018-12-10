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

@Entity
@Table(name="M_TECH_TRAINER")
public class TechnologyTrainerModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="M_TECH_TRAINER")
	@TableGenerator(name="M_TECH_TRAINER", table="S_SEQUENCE", pkColumnName="SEQUENCE_NAME", pkColumnValue="ID_TECH_TRAINER", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	private Long idTechTrainer;
	
	@Column(name="TECHNOLOGY_ID")
	private Long technologyId;
	
	@Column(name="TRAINER_ID")
	private Long trainerId;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@ManyToOne
	@JoinColumn(name="TECHNOLOGY_ID", insertable=false, updatable=false)
	private TechnologyModel technologyModel;
	
	@ManyToOne
	@JoinColumn(name="TRAINER_ID", insertable=false, updatable=false)
	private TrainerModel trainerModel;

	public Long getIdTechTrainer() {
		return idTechTrainer;
	}

	public void setIdTechTrainer(Long idTechTrainer) {
		this.idTechTrainer = idTechTrainer;
	}

	public Long getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public TechnologyModel getTechnologyModel() {
		return technologyModel;
	}

	public void setTechnologyModel(TechnologyModel technologyModel) {
		this.technologyModel = technologyModel;
	}

	public TrainerModel getTrainerModel() {
		return trainerModel;
	}

	public void setTrainerModel(TrainerModel trainerModel) {
		this.trainerModel = trainerModel;
	}
	
	
	
}
