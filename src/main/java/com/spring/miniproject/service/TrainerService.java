package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.TrainerModel;

public interface TrainerService {
	public void create(TrainerModel trainerModel);
	public List<TrainerModel> showAll();
	public List<TrainerModel> searchBy(String name);
	public TrainerModel searchById(Long id);
	public void edit(TrainerModel trainerModel);
}
