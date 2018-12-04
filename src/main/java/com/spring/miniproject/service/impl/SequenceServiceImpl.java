package com.spring.miniproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.SequenceDao;
import com.spring.miniproject.service.SequenceService;

@Service
@Transactional
public class SequenceServiceImpl implements SequenceService {
	
	@Autowired
	private SequenceDao sequenceDao;

	public Integer nextIdAkun() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdAkun();
	}

	@Override
	public Integer nextIdRole() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdRole();
	}

	@Override
	public Integer nextIdTechnology() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdTechnology();
	}

	@Override
	public Integer nextIdTrainer() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdTrainer();
	}

	@Override
	public Integer nextIdTechTrainer() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdTechTrainer();
	}
}
