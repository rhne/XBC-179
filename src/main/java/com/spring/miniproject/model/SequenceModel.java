package com.spring.miniproject.model;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="S_SEQUENCE")
public class SequenceModel {

	private String sequenceName;
	private Integer sequenceValue;
	
	@Id
	@Column(name="SEQUENCE_NAME")
	public String getSequenceName() {
		return sequenceName;
	}
	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}
	
	@Column(name="SEQUENCE_VALUE")
	public Integer getSequenceValue() {
		return sequenceValue;
	}
	public void setSequenceValue(Integer sequenceValue) {
		this.sequenceValue = sequenceValue;
	}
	
	
}
