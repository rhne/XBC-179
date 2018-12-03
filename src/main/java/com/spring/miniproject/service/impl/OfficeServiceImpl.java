package com.spring.miniproject.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.OfficeDao;
import com.spring.miniproject.model.OfficeModel;
import com.spring.miniproject.service.OfficeService;


@Service
@Transactional
public class OfficeServiceImpl implements OfficeService{
	
	@Autowired
	private OfficeDao officeDao;
	
	@Override
	public void create(OfficeModel officeModel) {
		// TODO Auto-generated method stub
		this.officeDao.create(officeModel);
	}
	
	public List<OfficeModel> searchAll() {
		// TODO Auto-generated method stub
		return this.officeDao.searchAll();
	}


}
