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
	private Long id;
	
	@Column(name="CREATED_BY")
	private Long createdBy;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="TRAINER_ID")
	private Long idTrainer;
	
	@Column(name="TECHNOLOGY_ID")
	private Long idTech;
	
	@ManyToOne
//	@Cascade({CascadeType.ALL})
	@JoinColumn(name="TECHNOLOGY_ID", insertable=false, updatable=false)
	private TechnologyModel technologyModel;
	
	@ManyToOne
	@JoinColumn(name="TRAINER_ID", insertable=false, updatable=false)
	private TrainerModel trainerModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdTrainer() {
		return idTrainer;
	}

	public void setIdTrainer(Long idTrainer) {
		this.idTrainer = idTrainer;
	}

	public Long getIdTech() {
		return idTech;
	}

	public void setIdTech(Long idTech) {
		this.idTech = idTech;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
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
	
	@ManyToOne
	@JoinColumn(name="CREATED_BY", insertable=false, updatable=false)
	private AkunModel akunModel;

	public AkunModel getAkunModel() {
		return akunModel;
	}

	public void setAkunModel(AkunModel akunModel) {
		this.akunModel = akunModel;
	}
	
	
	
}
