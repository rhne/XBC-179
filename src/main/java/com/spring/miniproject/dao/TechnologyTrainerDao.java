package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.TechnologyModel;
import com.spring.miniproject.model.TechnologyTrainerModel;

public interface TechnologyTrainerDao {
	public void create(TechnologyTrainerModel technologyTrainerModel);
	public List<TechnologyTrainerModel> showAll();
}
