package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.ClazzModel;

public interface ClazzDao {
	public void create(ClazzModel clazzModel);
	public void delete(ClazzModel clazzModel);
	public List<ClazzModel> showAll();
	public ClazzModel searchById(Long idClazz);
	public List<ClazzModel> searchByName(String name);
}
