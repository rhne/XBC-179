package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.MonitoringDao;
import com.spring.miniproject.model.MonitoringModel;

@Repository
public class MonitoringDaoImpl implements MonitoringDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void create(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(monitoringModel);
	}

	@SuppressWarnings("unchecked")
	public List<MonitoringModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<MonitoringModel> monitoringModelList = new ArrayList<MonitoringModel>();
		monitoringModelList = session.createQuery(" from MonitoringModel ").list();
		return monitoringModelList;
	}
}
