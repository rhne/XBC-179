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
@Table(name="M_BATCH")
public class BatchModel {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="M_BATCH")
	@TableGenerator(name="M_BATCH", table="S_SEQUENCE", pkColumnName="SEQUENCE_NAME", pkColumnValue="ID_BATCH", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	private Long batchId;
	
	@Column(name="ID_TECH")
	private Long technologyId;
	
	@Column(name="ID_TRAINER")
	private Long trainerId;
	
	@Column(name="ID_ROOM")
	private Long roomId;
	
	@Column(name="ID_BOOTCAMP")
	private Long bootcampId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="NOTES")
	private String notes;
	
	@Column(name="CREATED_BY")
	private Long createdBy;

	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="MODIFIED_BY")
	private Long modifiedBy;
	
	@Column(name="MODIFIED_ON")
	private Date modifiedOn;
	
	@Column(name="PERIOD_FROM")
	private Date periodFrom;
	
	@Column(name="PERIOD_TO")
	private Date periodTo;
	
	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
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

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getBootcampId() {
		return bootcampId;
	}

	public void setBootcampId(Long bootcampId) {
		this.bootcampId = bootcampId;
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

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Date getPeriodFrom() {
		return periodFrom;
	}

	public void setPeriodFrom(Date periodFrom) {
		this.periodFrom = periodFrom;
	}

	public Date getPeriodTo() {
		return periodTo;
	}

	public void setPeriodTo(Date periodTo) {
		this.periodTo = periodTo;
	}
	
//Many to One Relationship
	
	@ManyToOne
	@JoinColumn(name="ID_TECH", insertable=false, updatable=false)
	private TechnologyModel technologyModel;
	
	@ManyToOne
	@JoinColumn(name="ID_TRAINER", insertable=false, updatable=false)
	private TrainerModel trainerModel;

	@ManyToOne
	@JoinColumn(name="ID_ROOM", insertable=false, updatable=false)
	private RoomModel roomModel;
	
	@ManyToOne
	@JoinColumn(name="ID_BOOTCAMP", insertable=false, updatable=false)
	private BootcampTypeModel bootcampTypeModel;
	
	@ManyToOne
	@JoinColumn(name="CREATED_BY", insertable=false, updatable=false)
	private AkunModel akunModel;

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

	public RoomModel getRoomModel() {
		return roomModel;
	}

	public void setRoomModel(RoomModel roomModel) {
		this.roomModel = roomModel;
	}

	public BootcampTypeModel getBootcampTypeModel() {
		return bootcampTypeModel;
	}

	public void setBootcampTypeModel(BootcampTypeModel bootcampTypeModel) {
		this.bootcampTypeModel = bootcampTypeModel;
	}

	public AkunModel getAkunModel() {
		return akunModel;
	}

	public void setAkunModel(AkunModel akunModel) {
		this.akunModel = akunModel;
	}
	
	
}
