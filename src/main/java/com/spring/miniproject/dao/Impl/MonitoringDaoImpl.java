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
public class MonitoringDaoImpl implements MonitoringDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* Monitoring Add */
	public void create(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(monitoringModel);
	}

	/* Monitoring List */
	@SuppressWarnings("unchecked")
	public List<MonitoringModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<MonitoringModel> monitoringModelList = new ArrayList<MonitoringModel>();
		monitoringModelList = session.createQuery(" from MonitoringModel where isDelete=0").list();
		return monitoringModelList;
	}

	/* Select Monitoring ID to Modify */
	@Override
	public MonitoringModel searchById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return (MonitoringModel) session.createQuery("from MonitoringModel where id=" + id).getSingleResult();
	}

	/* Monitoring Edit */
	@Override
	public void update(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(monitoringModel);
	}

	/* Monitoring Search */
	@SuppressWarnings("unchecked")
	@Override
	public List<MonitoringModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select m from MonitoringModel m where m.biodataModel.name like '%" + name + "%' ";
		List<MonitoringModel> monitoringModelList = new ArrayList<MonitoringModel>();
		monitoringModelList = session.createQuery(query).list();
		return monitoringModelList;
	}

	/* Monitoring Delete */
	@Override
	public void delete(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(monitoringModel);
	}

	/* Monitoring Placement */
	@Override
	public void placement(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(monitoringModel);
	}
}
