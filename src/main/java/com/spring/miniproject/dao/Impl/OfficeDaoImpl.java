package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.OfficeDao;
import com.spring.miniproject.model.OfficeModel;

@Repository
public class OfficeDaoImpl implements OfficeDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<OfficeModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<OfficeModel> officeModelList = new ArrayList<OfficeModel>();
		officeModelList = session.createQuery(" from OfficeModel where isActive =1 ").list();
		return officeModelList;
	}

	@Override
	public OfficeModel create(OfficeModel officeModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(officeModel);
		return officeModel;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OfficeModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select a from OfficeModel a "
					 + " where a.name like '%"+name+"%' ";
		
		List<OfficeModel> officeModelList = new ArrayList<OfficeModel>();
		officeModelList = session.createQuery(query).list();
		
		return officeModelList;
	}
	
	@Override
	public OfficeModel searchById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (OfficeModel) session.createQuery("from OfficeModel where id=" + id).getSingleResult();
	}
	
	@Override
	public void delete(OfficeModel officeModel) {
		officeModel.setIsActive(0);
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(officeModel);
	}
}
