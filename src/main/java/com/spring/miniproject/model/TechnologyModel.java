package com.spring.miniproject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="M_TECHNOLOGY")
public class TechnologyModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="M_TECHNOLOGY")
	@TableGenerator(name="M_TECHNOLOGY", table="S_SEQUENCE", pkColumnName="SEQUENCE_NAME", pkColumnValue="ID_SEQ_TECH", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	@Column(name="ID")
	private Long id;
	
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
	
	@Column(name="ACTIVE")
	private Integer active;
	
	@OneToMany(mappedBy="technologyModel")
//	@Cascade({CascadeType.ALL})
	private List<TechnologyTrainerModel> technologyTrainer;
	
	@ManyToOne
	@JoinColumn(name="CREATED_BY", insertable=false, updatable=false)
	private AkunModel akunModel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	
	public List<TechnologyTrainerModel> getTechnologyTrainer() {
		return technologyTrainer;
	}
	public void setTechnologyTrainer(List<TechnologyTrainerModel> technologyTrainer) {
		this.technologyTrainer = technologyTrainer;
	}
	public AkunModel getAkunModel() {
		return akunModel;
	}
	public void setAkunModel(AkunModel akunModel) {
		this.akunModel = akunModel;
	}
	
}
