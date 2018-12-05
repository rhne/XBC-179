package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.TestimonyDao;
import com.spring.miniproject.model.TestimonyModel;
import com.spring.miniproject.service.TestimonyService;

@Service
@Transactional
public class TestimonyServiceImpl implements TestimonyService {

	@Autowired
	private TestimonyDao testimonyDao;
	
	@Override
	public void create(TestimonyModel testimonyModel) {
		// TODO Auto-generated method stub
		this.testimonyDao.create(testimonyModel);
	}

	@Override
	public List<TestimonyModel> showAll() {
		// TODO Auto-generated method stub
		return this.testimonyDao.showAll();
	}

	@Override
	public List<TestimonyModel> searchBy(String title) {
		// TODO Auto-generated method stub
		return this.testimonyDao.searchBy(title);
	}

	@Override
	public void edit(TestimonyModel testimonyModel) {
		// TODO Auto-generated method stub
		this.testimonyDao.edit(testimonyModel);
	}

	@Override
	public TestimonyModel searchById(Long idTestimony) {
		// TODO Auto-generated method stub
		return this.testimonyDao.searchById(idTestimony);
	}



}
