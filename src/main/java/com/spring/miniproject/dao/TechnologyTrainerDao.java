package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.TechnologyTrainerModel;

public interface TechnologyTrainerDao {
	public TechnologyTrainerModel create(TechnologyTrainerModel technologyTrainerModel);
	public List<TechnologyTrainerModel> showAll();
	public List<TechnologyTrainerModel> searchByIdTech(Long id);
	public void delete(TechnologyTrainerModel technologyTrainerModel);
	public TechnologyTrainerModel deleteById(Long id);
}
