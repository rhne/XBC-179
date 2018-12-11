package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.MonitoringDao;
import com.spring.miniproject.model.MonitoringModel;
import com.spring.miniproject.service.MonitoringService;

@Service
@Transactional
public class MonitoringServiceImpl implements MonitoringService{
	
	@Autowired
	private MonitoringDao monitoringDao;

	/* Monitoring Add */
	public void create(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		this.monitoringDao.create(monitoringModel);
	}

	/* Monitoring List */
	public List<MonitoringModel> searchAll() {
		// TODO Auto-generated method stub
		return this.monitoringDao.searchAll();
	}

	/* Select Monitoring ID to Modify */
	@Override
	public MonitoringModel searchById(Long id) {
		// TODO Auto-generated method stub
		return this.monitoringDao.searchById(id);
	}

	/* Monitoring Edit */
	@Override
	public void update(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		this.monitoringDao.update(monitoringModel);
	}

	/* Monitoring Search */
	@Override
	public List<MonitoringModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.monitoringDao.searchByLikeName(name);
	}

	/* Monitoring Delete */
	@Override
	public void delete(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		this.monitoringDao.delete(monitoringModel);
	}

	/* Monitoring Placement */
	@Override
	public void placement(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		this.monitoringDao.placement(monitoringModel);
	}
}
