package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.BootcampTestTypeModel;

public interface BootcampTestTypeService {
	public void create(BootcampTestTypeModel bootcamptesttypeModel);
	public List<BootcampTestTypeModel> searchAll();

}