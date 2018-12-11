package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.MonitoringModel;

public interface MonitoringDao {
	
	/* Monitoring Add */
	public void create(MonitoringModel monitoringModel);
	
	/* Monitoring List */
	public List<MonitoringModel> searchAll();
	
	/* Select Monitoring ID to Modify */
	public MonitoringModel searchById(Long id);
	
	/* Monitoring Edit */
	public void update(MonitoringModel monitoringModel);
	
	/* Monitoring Search */
	public List<MonitoringModel> searchByLikeName(String name);
	
	/* Monitoring isDelete */
	public void delete(MonitoringModel monitoringModel);
	
	/* Monitoring Placement */
	public void placement(MonitoringModel monitoringModel);
}
