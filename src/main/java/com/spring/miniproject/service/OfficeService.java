package com.spring.miniproject.service;

import java.util.List; 

import com.spring.miniproject.model.OfficeModel;

public interface OfficeService {
	public void create(OfficeModel officeModel);
	public List<OfficeModel> searchAll();

}
