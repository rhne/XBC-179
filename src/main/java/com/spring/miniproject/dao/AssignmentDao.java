package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.AssignmentModel;

public interface AssignmentDao {
	public void create(AssignmentModel assignmentModel);
	public List<AssignmentModel> searchAll();
}
