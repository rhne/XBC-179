package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.AssignmentDao;
import com.spring.miniproject.model.AssignmentModel;

@Repository
public class AssignmentDaoImpl implements AssignmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	/* Assignment Add */
	public void create(AssignmentModel assignmentModel) {
		// TODO Auto-generated method stub
		Long createdById = Long.valueOf(1);

		Session session = this.sessionFactory.getCurrentSession();
		assignmentModel.setCreatedOn(new Date());
		assignmentModel.setIsDelete(0);
		assignmentModel.setCreatedBy(createdById);
		session.save(assignmentModel);
	}

	/* Assignment List */
	@SuppressWarnings("unchecked")
	public List<AssignmentModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<AssignmentModel> assignmentModelList = new ArrayList<AssignmentModel>();
		assignmentModelList = session.createQuery(" from AssignmentModel where isDelete=0").list();
		return assignmentModelList;
	}

	/* Select Assignment ID to Modify */
	@Override
	public AssignmentModel searchById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return (AssignmentModel) session.createQuery("from AssignmentModel where id=" + id).getSingleResult();
	}

	/* Assignment Edit */
	@Override
	public void update(AssignmentModel assignmentModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		assignmentModel.setModifiedOn(new Date());
		session.update(assignmentModel);
	}

	/* Assignment Search */
	@SuppressWarnings("unchecked")
	@Override
	public List<AssignmentModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select m from AssignmentModel m where m.biodataModel.name like '%" + name + "%' ";

		List<AssignmentModel> assignmentModelList = new ArrayList<AssignmentModel>();
		assignmentModelList = session.createQuery(query).list();

		return assignmentModelList;
	}

	/* Assignment Deactivate */
	@Override
	public void delete(AssignmentModel assignmentModel) {
		// TODO Auto-generated method stub
		assignmentModel.setIsDelete(1);
		assignmentModel.setDeletedOn(new Date());

		Session session = this.sessionFactory.getCurrentSession();
		session.update(assignmentModel);
	}

	/* Assignment Hold */
	@Override
	public void hold(AssignmentModel assignmentModel) {
		// TODO Auto-generated method stub
		assignmentModel.setModifiedOn(new Date());
		assignmentModel.setIsHold(1);

		Session session = this.sessionFactory.getCurrentSession();
		session.update(assignmentModel);
	}

	/* Assignment Mark As Done */
	@Override
	public void markAsDone(AssignmentModel assignmentModel) {
		// TODO Auto-generated method stub
		assignmentModel.setModifiedOn(new Date());

		Session session = this.sessionFactory.getCurrentSession();
		session.update(assignmentModel);
	}
}
