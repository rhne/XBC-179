package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.BootcampTestTypeModel;
import com.spring.miniproject.model.OfficeModel;

public interface BootcampTestTypeDao {
	public void create(BootcampTestTypeModel bootcamptesttypeModel);
	public List<BootcampTestTypeModel> searchAll();
	public List<BootcampTestTypeModel> searchByLikeName(String name);
	public BootcampTestTypeModel searchById(Long id);
	public void delete(BootcampTestTypeModel bootcamptesttypeModel);
}
