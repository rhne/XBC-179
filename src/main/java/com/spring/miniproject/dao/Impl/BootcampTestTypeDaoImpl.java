package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;  
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.BootcampTestTypeDao;
import com.spring.miniproject.model.BootcampTestTypeModel;

@Repository
public class BootcampTestTypeDaoImpl implements BootcampTestTypeDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<BootcampTestTypeModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<BootcampTestTypeModel> bootcamptesttypeModelList = new ArrayList<BootcampTestTypeModel>();
		bootcamptesttypeModelList = session.createQuery(" from BootcampTestTypeModel ").list();
		return bootcamptesttypeModelList;
	}

	@Override
	public void create(BootcampTestTypeModel bootcamptesttypeModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(bootcamptesttypeModel);
	}

}
