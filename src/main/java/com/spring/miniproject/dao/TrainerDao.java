package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.TrainerModel;

public interface TrainerDao {

	public void create(TrainerModel trainerModel);
	public List<TrainerModel> showAll();
	public List<TrainerModel> searchBy(String name);
	public TrainerModel searchById(Long id);
	public void edit(TrainerModel trainerModel);
}
