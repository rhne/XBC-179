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
	public Integer nextIdMenu() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdMenu();
	}
	
	public Integer nextIdTechTrainer() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdTechTrainer();
	}
	
	@Override
	public Integer nextIdOffice() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdOffice();
	}
	
	@Override
	public Integer nextIdBootcampTestType() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdBootcampTestType();
	}
	
	@Override
	public Integer nextIdCategory() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdCategory();
	}
	@Override
	public Integer nextIdBiodata() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdBiodata();

	}

	@Override
	public Integer nextIdMonitoring() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdMonitoring();
	}

	@Override
	public Integer nextIdTestimony() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdTestimony();
	}
	
	@Override
	public Integer nextIdRoom() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdRoom();
	}

	@Override
	public Integer nextIdBatch() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdBatch();
	}

	@Override
	public Integer nextIdBootcamp() {
		// TODO Auto-generated method stub
		return this.sequenceDao.nextIdBootcamp();
	}
}
