package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.ClazzDao;
import com.spring.miniproject.model.ClazzModel;
import com.spring.miniproject.service.ClazzService;

@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

	@Autowired
	private ClazzDao clazzDao;

	@Override
	public void create(ClazzModel clazzModel) {
		// TODO Auto-generated method stub
		this.clazzDao.create(clazzModel);
	}

	@Override
	public void delete(ClazzModel clazzModel) {
		// TODO Auto-generated method stub
		this.clazzDao.delete(clazzModel);
	}

	@Override
	public List<ClazzModel> showAll() {
		// TODO Auto-generated method stub
		return this.clazzDao.showAll();
	}

	@Override
	public ClazzModel searchById(Long idClazz) {
		// TODO Auto-generated method stub
		return this.clazzDao.searchById(idClazz);
	}

	@Override
	public List<ClazzModel> searchByName(String name) {
		// TODO Auto-generated method stub
		return this.clazzDao.searchByName(name);
	}
}
