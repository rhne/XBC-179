package com.spring.miniproject.dao.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.VersionDao;
import com.spring.miniproject.model.VersionModel;

@Repository
public class VersionDaoImpl implements VersionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<VersionModel> searchAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from VersionModel").list();
	}

	@Override
	public void create(VersionModel versionModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(versionModel);
	}

	@Override
	public VersionModel searchById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (VersionModel) session.createQuery("from VersionModel where id=" + id).getSingleResult();
	}

	@Override
	public void update(VersionModel versionModel) {
		versionModel.setModifiedOn(new Date());
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(versionModel);
	}

	@Override
	public void delete(VersionModel versionModel) {
		versionModel.setIsDelete(1);
		versionModel.setDeletedOn(new Date());
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(versionModel);
	}

}
