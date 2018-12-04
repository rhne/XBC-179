package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.MonitoringModel;;

public interface MonitoringService {
	public void create(MonitoringModel monitoringModel);
	public List<MonitoringModel> searchAll();
}
