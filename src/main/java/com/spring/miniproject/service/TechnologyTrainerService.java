package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.TechnologyTrainerModel;

public interface TechnologyTrainerService {

	public void create(TechnologyTrainerModel technologyTrainerModel);
	public List<TechnologyTrainerModel> showAll();
}
