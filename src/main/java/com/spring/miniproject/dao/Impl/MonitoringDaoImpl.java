package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
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

	public void create(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		Long createdById = Long.valueOf(1);
		
		Session session = this.sessionFactory.getCurrentSession();
		monitoringModel.setCreatedOn(new Date());
		monitoringModel.setIsDelete(0);
		monitoringModel.setCreatedBy(createdById);
		session.save(monitoringModel);
	}

	@SuppressWarnings("unchecked")
	public List<MonitoringModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<MonitoringModel> monitoringModelList = new ArrayList<MonitoringModel>();
		monitoringModelList = session.createQuery(" from MonitoringModel where isDelete=0").list();
		return monitoringModelList;
	}

	@Override
	public MonitoringModel searchById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return (MonitoringModel) session.createQuery("from MonitoringModel where id=" + id).getSingleResult();
	}

	@Override
	public void update(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		monitoringModel.setModifiedOn(new Date());
		session.update(monitoringModel);
	}

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

	@Override
	public void delete(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		monitoringModel.setIsDelete(1);
		monitoringModel.setDeletedOn(new Date());

		Session session = this.sessionFactory.getCurrentSession();
		session.update(monitoringModel);
	}

	@Override
	public void placement(MonitoringModel monitoringModel) {
		// TODO Auto-generated method stub
		monitoringModel.setModifiedOn(new Date());

		Session session = this.sessionFactory.getCurrentSession();
		session.update(monitoringModel);
	}
}
