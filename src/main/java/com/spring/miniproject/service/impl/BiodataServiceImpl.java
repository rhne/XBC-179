package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.BiodataDao;
import com.spring.miniproject.model.BiodataModel;
import com.spring.miniproject.service.BiodataService;

@Service
@Transactional
public class BiodataServiceImpl implements BiodataService {

	@Autowired
	private BiodataDao biodataDao;

	public void create(BiodataModel biodataModel) {
		// TODO Auto-generated method stub
		this.biodataDao.create(biodataModel);
	}

	public List<BiodataModel> searchAll() {
		// TODO Auto-generated method stub
		return this.biodataDao.searchAll();
	}

	@Override
	public BiodataModel searchById(Long id) {
		// TODO Auto-generated method stub
		return this.biodataDao.searchById(id);
	}

	@Override
	public void update(BiodataModel biodataModel) {
		// TODO Auto-generated method stub
		this.biodataDao.update(biodataModel);

	}

	@Override
	public List<BiodataModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.biodataDao.searchByLikeName(name);
	}

	@Override
	public void deactivate(BiodataModel biodataModel) {
		// TODO Auto-generated method stub
		this.biodataDao.deactivate(biodataModel);

	}
}
