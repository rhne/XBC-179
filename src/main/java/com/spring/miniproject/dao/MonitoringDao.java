package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.MonitoringModel;

public interface MonitoringDao {
	public void create(MonitoringModel monitoringModel);
	public List<MonitoringModel> searchAll();
}
