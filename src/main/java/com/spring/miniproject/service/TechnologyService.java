package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.TechnologyModel;

public interface TechnologyService {
	public void create(TechnologyModel technologyModel);
	public List<TechnologyModel> showAll();
}
