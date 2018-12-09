package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.TechnologyDao;
import com.spring.miniproject.model.TechnologyModel;
import com.spring.miniproject.service.TechnologyService;

@Service
@Transactional
public class TechnologyServiceImpl implements TechnologyService{

	@Autowired
	private TechnologyDao technologyDao;

	@Override
	public TechnologyModel create(TechnologyModel technologyModel) {
		// TODO Auto-generated method stub
		return this.technologyDao.create(technologyModel);
	}

	@Override
	public List<TechnologyModel> showAll() {
		// TODO Auto-generated method stub
		return this.technologyDao.showAll();
	}

	@Override
	public List<TechnologyModel> searchBy(String text) {
		// TODO Auto-generated method stub
		return this.technologyDao.searchBy(text);
	}

	@Override
	public void edit(TechnologyModel technologyModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TechnologyModel searchById(Long idTech) {
		// TODO Auto-generated method stub
		return this.technologyDao.searchById(idTech);
	}

	@Override
	public TechnologyModel delete(TechnologyModel technologyModel) {
		// TODO Auto-generated method stub
		return this.technologyDao.delete(technologyModel);
	}
}
