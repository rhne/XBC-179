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

	/* Biodata Add */
	public void create(BiodataModel biodataModel) {
		// TODO Auto-generated method stub
		this.biodataDao.create(biodataModel);
	}

	/* Biodata List */
	public List<BiodataModel> searchAll() {
		// TODO Auto-generated method stub
		return this.biodataDao.searchAll();
	}

	/* Select Biodata ID to Modify */
	@Override
	public BiodataModel searchById(Long id) {
		// TODO Auto-generated method stub
		return this.biodataDao.searchById(id);
	}

	/* Biodata Edit */
	@Override
	public void update(BiodataModel biodataModel) {
		// TODO Auto-generated method stub
		this.biodataDao.update(biodataModel);
	}

	/* Biodata Search */
	@Override
	public List<BiodataModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.biodataDao.searchByLikeName(name);
	}

	/* Biodata Deactivate */
	@Override
	public void deactivate(BiodataModel biodataModel) {
		// TODO Auto-generated method stub
		this.biodataDao.deactivate(biodataModel);
	}
}
