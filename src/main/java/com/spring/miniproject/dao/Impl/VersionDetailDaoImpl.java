package com.spring.miniproject.dao.Impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.VersionDetailDao;
import com.spring.miniproject.model.VersionDetailModel;

@Repository
public class VersionDetailDaoImpl implements VersionDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public VersionDetailModel create(VersionDetailModel versionDetailModel) {
		versionDetailModel.setCreatedOn(new Date());
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(versionDetailModel);
		return versionDetailModel;
	}

}
