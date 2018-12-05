package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.BootcampTestTypeModel;

public interface BootcampTestTypeDao {
	public void create(BootcampTestTypeModel bootcamptesttypeModel);
	public List<BootcampTestTypeModel> searchAll();
	public List<BootcampTestTypeModel> searchByLikeName(String name);
}
