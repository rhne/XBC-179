package com.spring.miniproject.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.OfficeDao;
import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.model.OfficeModel;
import com.spring.miniproject.service.OfficeService;


@Service
@Transactional
public class OfficeServiceImpl implements OfficeService{
	
	@Autowired
	private OfficeDao officeDao;
	
	@Override
	public OfficeModel create(OfficeModel officeModel) {
		// TODO Auto-generated method stub
		return this.officeDao.create(officeModel);
	}
	
	public List<OfficeModel> searchAll() {
		// TODO Auto-generated method stub
		return this.officeDao.searchAll();
	}

	@Override
	public List<OfficeModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.officeDao.searchByLikeName(name);
	}
	
	@Override
	public OfficeModel searchById(Long id) {
		return this.officeDao.searchById(id);
	}
	
	@Override
	public void delete(OfficeModel officeModel) {
		this.officeDao.delete(officeModel);
	}
	@Override
	public void update(OfficeModel officeModel) {
		// TODO Auto-generated method stub
		this.officeDao.update(officeModel);
	}
}
