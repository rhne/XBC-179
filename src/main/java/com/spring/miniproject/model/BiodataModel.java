package com.spring.miniproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "B_BIODATA")
public class BiodataModel {

	private Long id;
	private String name;
	private String gender;
	private String last_education;
	private String graduation_year;
	private String educational_level;
	private String majors;
	private String gpa;
	private Long bootcamp_test_type;
	private Integer iq;
	private String du;
	private Integer arithmetic;
	private Integer nested_logic;
	private Integer join_table;
	private String tro;
	private String notes;
	private String interviewer;
/*
	// AuditTrail////////////////////
	private Integer isActive;

	private Long createdBy;
	private AkunModel createdByUser;
	private Date createdOn;

	private Integer modifiedBy;
	private AkunModel modifiedByUser;
	private Date modifiedOn;
	// AuditTrail/////////////////////
*/	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="B_BIODATA")
	@TableGenerator(name="B_BIODATA", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="B_BIODATA_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the last_education
	 */
	public String getLast_education() {
		return last_education;
	}
	/**
	 * @param last_education the last_education to set
	 */
	public void setLast_education(String last_education) {
		this.last_education = last_education;
	}
	/**
	 * @return the graduation_year
	 */
	public String getGraduation_year() {
		return graduation_year;
	}
	/**
	 * @param graduation_year the graduation_year to set
	 */
	public void setGraduation_year(String graduation_year) {
		this.graduation_year = graduation_year;
	}
	/**
	 * @return the educational_level
	 */
	public String getEducational_level() {
		return educational_level;
	}
	/**
	 * @param educational_level the educational_level to set
	 */
	public void setEducational_level(String educational_level) {
		this.educational_level = educational_level;
	}
	/**
	 * @return the majors
	 */
	public String getMajors() {
		return majors;
	}
	/**
	 * @param majors the majors to set
	 */
	public void setMajors(String majors) {
		this.majors = majors;
	}
	/**
	 * @return the gpa
	 */
	public String getGpa() {
		return gpa;
	}
	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	/**
	 * @return the bootcamp_test_type
	 */
	public Long getBootcamp_test_type() {
		return bootcamp_test_type;
	}
	/**
	 * @param bootcamp_test_type the bootcamp_test_type to set
	 */
	public void setBootcamp_test_type(Long bootcamp_test_type) {
		this.bootcamp_test_type = bootcamp_test_type;
	}
	/**
	 * @return the iq
	 */
	public Integer getIq() {
		return iq;
	}
	/**
	 * @param iq the iq to set
	 */
	public void setIq(Integer iq) {
		this.iq = iq;
	}
	/**
	 * @return the du
	 */
	public String getDu() {
		return du;
	}
	/**
	 * @param du the du to set
	 */
	public void setDu(String du) {
		this.du = du;
	}
	/**
	 * @return the arithmetic
	 */
	public Integer getArithmetic() {
		return arithmetic;
	}
	/**
	 * @param arithmetic the arithmetic to set
	 */
	public void setArithmetic(Integer arithmetic) {
		this.arithmetic = arithmetic;
	}
	/**
	 * @return the nested_logic
	 */
	public Integer getNested_logic() {
		return nested_logic;
	}
	/**
	 * @param nested_logic the nested_logic to set
	 */
	public void setNested_logic(Integer nested_logic) {
		this.nested_logic = nested_logic;
	}
	/**
	 * @return the join_table
	 */
	public Integer getJoin_table() {
		return join_table;
	}
	/**
	 * @param join_table the join_table to set
	 */
	public void setJoin_table(Integer join_table) {
		this.join_table = join_table;
	}
	/**
	 * @return the tro
	 */
	public String getTro() {
		return tro;
	}
	/**
	 * @param tro the tro to set
	 */
	public void setTro(String tro) {
		this.tro = tro;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * @return the interviewer
	 */
	public String getInterviewer() {
		return interviewer;
	}
	/**
	 * @param interviewer the interviewer to set
	 */
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
}
