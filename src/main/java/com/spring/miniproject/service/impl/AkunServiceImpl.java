package com.spring.miniproject.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.AkunDao;
import com.spring.miniproject.model.AkunModel;
import com.spring.miniproject.service.AkunService;

@Service
@Transactional
public class AkunServiceImpl implements AkunService{
	
	@Autowired
	private AkunDao akunDao;

	public void create(AkunModel akunModel) {
		// TODO Auto-generated method stub
		this.akunDao.create(akunModel);
	}

	public List<AkunModel> searchAll() {
		// TODO Auto-generated method stub
		return this.akunDao.searchAll();
	}

	@Override
	public AkunModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.akunDao.searchById(id);
	}

	@Override
	public void update(AkunModel akunModel) {
		// TODO Auto-generated method stub
		this.akunDao.update(akunModel);
	}

	@Override
	public List<AkunModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.akunDao.searchByLikeName(name);
	}
}
