package com.spring.miniproject.dao;

import java.util.List; 

import com.spring.miniproject.model.OfficeModel;

public interface OfficeDao {
	public void create(OfficeModel officeModel);
	public List<OfficeModel> searchAll();

}
