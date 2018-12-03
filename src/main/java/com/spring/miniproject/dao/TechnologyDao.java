package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.TechnologyModel;

public interface TechnologyDao {
	public void crete(TechnologyModel technologyModel);
	public List<TechnologyModel> showAll();
}
