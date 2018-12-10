package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.BootcampTypeDao;
import com.spring.miniproject.model.BootcampTypeModel;
import com.spring.miniproject.service.BootcampTypeService;

@Service
@Transactional
public class BootcampTypeServiceImpl implements BootcampTypeService {

	@Autowired
	private BootcampTypeDao bootcampTypeDao;
	
	@Override
	public void create(BootcampTypeModel bootcampTypeModel) {
		// TODO Auto-generated method stub
		this.bootcampTypeDao.create(bootcampTypeModel);
	}

	@Override
	public void edit(BootcampTypeModel bootcampTypeModel) {
		// TODO Auto-generated method stub
		this.bootcampTypeDao.edit(bootcampTypeModel);
	}

	@Override
	public List<BootcampTypeModel> showAll() {
		// TODO Auto-generated method stub
		return this.bootcampTypeDao.showAll();
	}

	@Override
	public BootcampTypeModel searchById(Long idBootcamp) {
		// TODO Auto-generated method stub
		return this.bootcampTypeDao.searchById(idBootcamp);
	}

	@Override
	public List<BootcampTypeModel> searchByName(String name) {
		// TODO Auto-generated method stub
		return this.bootcampTypeDao.searchByName(name);
	}

}
