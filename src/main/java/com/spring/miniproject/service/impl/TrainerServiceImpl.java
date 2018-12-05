package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.TrainerDao;
import com.spring.miniproject.model.TrainerModel;
import com.spring.miniproject.service.TrainerService;

@Service
@Transactional
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	private TrainerDao trainerDao;
	
	@Override
	public void create(TrainerModel trainerModel) {
		// TODO Auto-generated method stub
		this.trainerDao.create(trainerModel);
	}

	@Override
	public List<TrainerModel> showAll() {
		// TODO Auto-generated method stub
		return this.trainerDao.showAll();
	}

}
