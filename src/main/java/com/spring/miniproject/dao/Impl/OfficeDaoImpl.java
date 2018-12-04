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
	public void create(OfficeModel officeModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(officeModel);
	}
}
