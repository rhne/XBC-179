package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.TechnologyTrainerDao;
import com.spring.miniproject.model.TechnologyTrainerModel;
import com.spring.miniproject.service.TechnologyTrainerService;

@Service
@Transactional
public class TechnologyTrainerServiceImpl implements TechnologyTrainerService {

	@Autowired
	private TechnologyTrainerDao technologyTrainerDao;
	
	@Override
	public TechnologyTrainerModel create(TechnologyTrainerModel technologyTrainerModel) {
		// TODO Auto-generated method stub
		return this.technologyTrainerDao.create(technologyTrainerModel);
	}

	@Override
	public List<TechnologyTrainerModel> showAll() {
		// TODO Auto-generated method stub
		return this.technologyTrainerDao.showAll();
	}


}
