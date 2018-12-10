package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.BootcampTypeModel;

public interface BootcampTypeDao {
	public void create(BootcampTypeModel bootcampTypeModel);
	public void edit(BootcampTypeModel bootcampTypeModel);
	public List<BootcampTypeModel> showAll();
	public BootcampTypeModel searchById(Long idBootcamp);
	public List<BootcampTypeModel> searchByName(String name);
}
