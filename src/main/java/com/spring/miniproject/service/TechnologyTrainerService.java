package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.TechnologyTrainerModel;

public interface TechnologyTrainerService {

	public TechnologyTrainerModel create(TechnologyTrainerModel technologyTrainerModel);
	public List<TechnologyTrainerModel> showAll();
	public List<TechnologyTrainerModel> searchByIdTech(Long id);
}
