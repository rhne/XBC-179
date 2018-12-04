package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.AssignmentDao;
import com.spring.miniproject.model.AssignmentModel;
import com.spring.miniproject.service.AssignmentService;

@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService{
	
	@Autowired
	private AssignmentDao assignmentDao;

	public void create(AssignmentModel assignmentModel) {
		// TODO Auto-generated method stub
		this.assignmentDao.create(assignmentModel);
	}

	public List<AssignmentModel> searchAll() {
		// TODO Auto-generated method stub
		return this.assignmentDao.searchAll();
	}
}
