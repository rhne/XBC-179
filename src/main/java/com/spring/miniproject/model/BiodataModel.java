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

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "B_BIODATA")
public class BiodataModel {

	private Long id;
	private String name;
	private String gender;
	private String lastEducation;
	private String graduationYear;
	private String educationalLevel;
	private String majors;
	private String gpa;
	private Integer iq;
	private String du;
	private Integer arithmetic;
	private Integer nestedLogic;
	private Integer joinTable;
	private String tro;
	private String notes;
	private String interviewer;

	private BootcampTestTypeModel bootcampTestTypeModel;
	private Long bootcampTestType;
	
	private AkunModel createdByUser;
	private AkunModel modifiedByUser;

	// AuditTrail////////////////////
	private Long createdBy;
	private Date createdOn;
	private Long modifiedBy;
	private Date modifiedOn;
	private Integer active;
	// AuditTrail/////////////////////

	/* Auto Increment */
	@Id
	@Column(name = "ID", nullable = false, length = 11)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "B_BIODATA")
	@TableGenerator(name = "B_BIODATA", table = "S_SEQUENCE", pkColumnName = "SEQUENCE_NAME", pkColumnValue = "B_BIODATA_ID", valueColumnName = "SEQUENCE_VALUE", allocationSize = 1, initialValue = 0)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false, length = 255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "GENDER", length = 255)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "LAST_EDUCATION", nullable = false, length = 100)
	public String getLastEducation() {
		return lastEducation;
	}
	public void setLastEducation(String lastEducation) {
		this.lastEducation = lastEducation;
	}

	@Column(name = "GRADUATION_YEAR", nullable = false, length = 5)
	public String getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	@Column(name = "EDUCATIONAL_LEVEL", nullable = false, length = 5)
	public String getEducationalLevel() {
		return educationalLevel;
	}
	public void setEducationalLevel(String educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	@Column(name = "MAJORS", nullable = false, length = 100)
	public String getMajors() {
		return majors;
	}
	public void setMajors(String majors) {
		this.majors = majors;
	}

	@Column(name = "GPA", nullable = false, length = 5)
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	@Column(name = "BOOTCAMP_TEST_TYPE_ID", length = 11)
	public Long getBootcampTestType() {
		return bootcampTestType;
	}
	public void setBootcampTestType(Long bootcampTestType) {
		this.bootcampTestType = bootcampTestType;
	}

	@Column(name = "IQ", length = 4)
	public Integer getIq() {
		return iq;
	}
	public void setIq(Integer iq) {
		this.iq = iq;
	}

	@Column(name = "DU", length = 10)
	public String getDu() {
		return du;
	}
	public void setDu(String du) {
		this.du = du;
	}

	@Column(name = "ARITHMETIC", length = 5)
	public Integer getArithmetic() {
		return arithmetic;
	}
	public void setArithmetic(Integer arithmetic) {
		this.arithmetic = arithmetic;
	}

	@Column(name = "NESTED_LOGIC", length = 5)
	public Integer getNestedLogic() {
		return nestedLogic;
	}
	public void setNestedLogic(Integer nestedLogic) {
		this.nestedLogic = nestedLogic;
	}

	@Column(name = "JOIN_TABLE", length = 5)
	public Integer getJoinTable() {
		return joinTable;
	}
	public void setJoinTable(Integer joinTable) {
		this.joinTable = joinTable;
	}

	@Column(name = "TRO", length = 50)
	public String getTro() {
		return tro;
	}
	public void setTro(String tro) {
		this.tro = tro;
	}
	
	@Column(name = "NOTES", length = 100)
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "INTERVIEWER", length = 100)
	public String getInterviewer() {
		return interviewer;
	}
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
	
	/* User Login ID */
	@CreatedBy
	@Column(name = "CREATED_BY", nullable=false, length = 11)
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/* Tanggal Dibuat */
	@CreationTimestamp
	@Column(name = "CREATED_ON", nullable=false)
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/* User Login ID */
	@LastModifiedBy
	@Column(name = "MODIFIED_BY", length = 11)
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/* Tanggal Diupdate */
	@LastModifiedDate
	@Column(name = "MODIFIED_ON")
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/* active : 1
	 * not active : 0
	 * */
	@Column(name = "ACTIVE")
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	
	/* Bootcamp Test Type Join Table Bootcamp Test Type */
	@ManyToOne
	@JoinColumn(name = "BOOTCAMP_TEST_TYPE_ID", updatable = false, insertable = false)
	public BootcampTestTypeModel getBootcampTestTypeModel() {
		return bootcampTestTypeModel;
	}
	public void setBootcampTestTypeModel(BootcampTestTypeModel bootcampTestTypeModel) {
		this.bootcampTestTypeModel = bootcampTestTypeModel;
	}
	
	/* Created By Join Table Akun */
	@ManyToOne
	@JoinColumn(name="CREATED_BY",nullable=false, updatable=false, insertable=false)
	public AkunModel getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(AkunModel createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	/* Modified By Join Table Akun */
	@ManyToOne
	@JoinColumn(name="MODIFIED_BY",nullable=false, updatable=false, insertable=false)
	public AkunModel getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(AkunModel modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}

}
