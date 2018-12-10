package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.BatchDao;
import com.spring.miniproject.model.BatchModel;
import com.spring.miniproject.service.BatchService;

@Service
@Transactional
public class BatchServiceImpl implements BatchService{
	
	@Autowired
	private BatchDao batchDao;

	@Override
	public void create(BatchModel batchModel) {
		// TODO Auto-generated method stub
		this.batchDao.create(batchModel);
	}

	@Override
	public void edit(BatchModel batchModel) {
		// TODO Auto-generated method stub
		this.batchDao.edit(batchModel);
	}

	@Override
	public List<BatchModel> showAll() {
		// TODO Auto-generated method stub
		return this.batchDao.showAll();
	}

	@Override
	public BatchModel searchById(Long idBatch) {
		// TODO Auto-generated method stub
		return this.batchDao.searchById(idBatch);
	}

	@Override
	public List<BatchModel> searchBy(String nameTech) {
		// TODO Auto-generated method stub
		return this.batchDao.searchBy(nameTech);
	}
}
