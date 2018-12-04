package com.spring.miniproject.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.BootcampTestTypeDao;
import com.spring.miniproject.model.BootcampTestTypeModel;
import com.spring.miniproject.service.BootcampTestTypeService;


@Service
@Transactional
public class BootcampTestTypeServiceImpl implements BootcampTestTypeService{
	
	@Autowired
	private BootcampTestTypeDao bootcamptesttypeDao;
	
	@Override
	public void create(BootcampTestTypeModel bootcamptesttypeModel) {
		// TODO Auto-generated method stub
		this.bootcamptesttypeDao.create(bootcamptesttypeModel);
	}
	
	public List<BootcampTestTypeModel> searchAll() {
		// TODO Auto-generated method stub
		return this.bootcamptesttypeDao.searchAll();
	}



}
