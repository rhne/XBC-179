package com.spring.miniproject.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="M_BATCH")
public class BatchModel {

	private Long technologyId;
	
	private Long trainerId;
	
	private Long roomId;
	
	private Long bootcampTypeId;
	
	private String name;
	
	private Date periodFrom;
	
	private Date periodTo;
	
	private String notes;
	
	private Long createdBy;
	
	private LocalDateTime createdOn;
	
	private Long modifiedBy;
	
	private LocalDateTime modifiedOn;
	
	private Long deletedBy;
	
	private LocalDateTime deletedOn;
	
	private Integer isDeleted;
}
