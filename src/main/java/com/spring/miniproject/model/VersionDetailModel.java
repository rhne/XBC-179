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
@Table(name="T_VERSION_DETAIL")
public class VersionDetailModel {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_VERSION_DETAIL")
	@TableGenerator(name="T_VERSION_DETAIL", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="T_VERSION_DETAIL_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	private Long id;

	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
	private QuestionModel question;
	
	@ManyToOne
	@JoinColumn(name="VERSION_ID")
	private VersionModel version;
	
	@Column(name="CREATED_ON")
	private Date createdOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QuestionModel getQuestion() {
		return question;
	}

	public void setQuestion(QuestionModel question) {
		this.question = question;
	}

	
	public VersionModel getVersion() {
		return version;
	}

	public void setVersion(VersionModel version) {
		this.version = version;
		//version.getVersionDetails().add(this);
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
}
