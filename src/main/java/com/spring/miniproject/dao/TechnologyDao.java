package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.TechnologyModel;

public interface TechnologyDao {
	public TechnologyModel create(TechnologyModel technologyModel);
	public List<TechnologyModel> showAll();
	public List<TechnologyModel> searchBy(String text);
	public TechnologyModel searchById(Long idTech);
	public void edit(TechnologyModel technologyModel);
	public TechnologyModel delete(TechnologyModel technologyModel);
}
