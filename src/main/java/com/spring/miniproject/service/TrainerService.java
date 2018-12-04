package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.TrainerModel;

public interface TrainerService {
	public void create(TrainerModel trainerModel);
	public List<TrainerModel> showAll();
}
