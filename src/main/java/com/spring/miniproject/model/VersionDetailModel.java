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
@Table(name="T_VERSION_DETAIL")
public class VersionDetailModel {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="T_VERSION_DETAIL")
	@TableGenerator(name="T_VERSION_DETAIL", table="S_SEQUENCE",
			pkColumnName="SEQUENCE_NAME", pkColumnValue="T_VERSION_DETAIL_ID",
			valueColumnName="SEQUENCE_VALUE", allocationSize =1, initialValue=0)
	private Long id;
	@Column(name="QUESTION_ID")
	private Long questionId;
	@Column(name="VERSION_ID")
	private Long versionId;
	@Column(name="CREATED_ON")
	private Date createdOn;
	
}
