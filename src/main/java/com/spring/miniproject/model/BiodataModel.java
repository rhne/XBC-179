package com.spring.miniproject.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "B_BIODATA")
public class BiodataModel {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="B_BIODATA")
	@TableGenerator(name="B_BIODATA", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="B_BIODATA_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="LAST_EDUCATION")
	private String lastEducation;
	
	@Column(name="GRADUATION_YEAR")
	private String graduationYear;
	
	@Column(name="EDUCATIONAL_LEVEL")
	private String educationalLevel;
	
	@Column(name="MAJORS")
	private String majors;
	
	@Column(name="GPA")
	private String gpa;
	
	@Column(name="BOOTCAMP_TEST_TYPE")
	private Long bootcampTestType;
	
	@Column(name="IQ")
	private Integer iq;
	
	@Column(name="DU")
	private String du;
	
	@Column(name="ARITHMETIC")
	private Integer arithmetic;
	
	@Column(name="NESTED_LOGIC")
	private Integer nestedLogic;
	
	@Column(name="JOIN_TABLE")
	private Integer joinTable;
	
	@Column(name="TRO")
	private String tro;
	
	@Column(name="NOTES")
	private String notes;
	
	@Column(name="INTERVIEWER")
	private String interviewer;

	// AuditTrail////////////////////
	@CreatedBy
	@Column(name="CREATED_BY")
	private Long createdBy;
	
	@CreatedDate
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;
	
	@LastModifiedBy
	@Column(name="MODIFIED_BY")
	private Integer modifiedBy;
	
	@LastModifiedDate
	@Column(name="MODIFIED_ON")
	private LocalDateTime modifiedOn;
	
	@Column(name="ACTIVE")
	private Integer active;
	
	/*private AkunModel createdByUser;
	private AkunModel modifiedByUser;*/
	// AuditTrail/////////////////////
	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastEducation() {
		return lastEducation;
	}

	public void setLastEducation(String lastEducation) {
		this.lastEducation = lastEducation;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	public String getEducationalLevel() {
		return educationalLevel;
	}

	public void setEducationalLevel(String educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public Long getBootcampTestType() {
		return bootcampTestType;
	}

	public void setBootcampTestType(Long bootcampTestType) {
		this.bootcampTestType = bootcampTestType;
	}

	public Integer getIq() {
		return iq;
	}

	public void setIq(Integer iq) {
		this.iq = iq;
	}

	public String getDu() {
		return du;
	}

	public void setDu(String du) {
		this.du = du;
	}

	public Integer getArithmetic() {
		return arithmetic;
	}

	public void setArithmetic(Integer arithmetic) {
		this.arithmetic = arithmetic;
	}

	public Integer getNestedLogic() {
		return nestedLogic;
	}

	public void setNestedLogic(Integer nestedLogic) {
		this.nestedLogic = nestedLogic;
	}

	public Integer getJoinTable() {
		return joinTable;
	}

	public void setJoinTable(Integer joinTable) {
		this.joinTable = joinTable;
	}

	public String getTro() {
		return tro;
	}

	public void setTro(String tro) {
		this.tro = tro;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
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
