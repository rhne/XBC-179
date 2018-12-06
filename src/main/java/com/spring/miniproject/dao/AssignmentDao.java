package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.AssignmentModel;
import com.spring.miniproject.model.MonitoringModel;

public interface AssignmentDao {
	public void create(AssignmentModel assignmentModel);
	public List<AssignmentModel> searchAll();
	public AssignmentModel searchById(Long id);
	public void update(AssignmentModel assignmentModel);
	public List<AssignmentModel> searchByLikeName(String name);
	public void delete(AssignmentModel assignmentModel);
	public void hold(AssignmentModel assignmentModel);
	public void markAsDone(AssignmentModel assignmentModel);
}
