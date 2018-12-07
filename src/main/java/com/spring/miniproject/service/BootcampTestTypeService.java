package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.BootcampTestTypeModel;

public interface BootcampTestTypeService {
	public void create(BootcampTestTypeModel bootcamptesttypeModel);
	public List<BootcampTestTypeModel> searchAll();
	public List<BootcampTestTypeModel> searchByLikeName(String name);
	public BootcampTestTypeModel searchById(Long id);
	public void delete(BootcampTestTypeModel bootcamptesttypeModel);
	public void update(BootcampTestTypeModel bootcamptesttypeModel);
}
