package com.spring.miniproject.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.IdleNewsDao;
import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.model.IdleNewsModel;
import com.spring.miniproject.model.OfficeModel;
import com.spring.miniproject.service.IdleNewsService;


@Service
@Transactional
public class IdleNewsServiceImpl implements IdleNewsService{
	
	@Autowired
	private IdleNewsDao idlenewsDao;
	
	@Override
	public void create(IdleNewsModel idlenewsModel) {
		// TODO Auto-generated method stub
		this.idlenewsDao.create(idlenewsModel);
	}
	
	public List<IdleNewsModel> searchAll() {
		// TODO Auto-generated method stub
		return this.idlenewsDao.searchAll();
	}

	@Override
	public List<IdleNewsModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.idlenewsDao.searchByLikeName(name);
	}
	
	@Override
	public IdleNewsModel searchById(Long id) {
		return this.idlenewsDao.searchById(id);
	}
	
	@Override
	public void delete(IdleNewsModel idlenewsModel) {
		this.idlenewsDao.delete(idlenewsModel);
	}
}
