package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.AssignmentDao;
import com.spring.miniproject.model.AssignmentModel;

@Repository
public class AssignmentDaoImpl implements AssignmentDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void create(AssignmentModel assignmentModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(assignmentModel);
	}

	@SuppressWarnings("unchecked")
	public List<AssignmentModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<AssignmentModel> assignmentModelList = new ArrayList<AssignmentModel>();
		assignmentModelList = session.createQuery(" from AssignmentModel ").list();
		return assignmentModelList;
	}
}
