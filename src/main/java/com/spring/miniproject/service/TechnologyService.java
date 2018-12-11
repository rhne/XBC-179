package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.TechnologyModel;

public interface TechnologyService {
	public TechnologyModel create(TechnologyModel technologyModel);
	public List<TechnologyModel> showAll();
	public List<TechnologyModel> searchBy(String text);
	public void edit(TechnologyModel technologyModel);
	public TechnologyModel searchById(Long id);
	public TechnologyModel delete(TechnologyModel technologyModel);
}
