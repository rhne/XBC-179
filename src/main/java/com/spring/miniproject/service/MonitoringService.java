package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.MonitoringModel;;

public interface MonitoringService {
	public void create(MonitoringModel monitoringModel);
	public List<MonitoringModel> searchAll();
	public MonitoringModel searchById(Long id);
	public void update(MonitoringModel monitoringModel);
	public List<MonitoringModel> searchByLikeName(String name);
	public void delete(MonitoringModel monitoringModel);
	public void placement(MonitoringModel monitoringModel);
}
