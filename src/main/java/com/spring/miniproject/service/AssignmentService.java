package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.AssignmentModel;

public interface AssignmentService {
	public void create(AssignmentModel assignmentModel);
	public List<AssignmentModel> searchAll();
	public AssignmentModel searchById(Long id);
	public void update(AssignmentModel assignmentModel);
	public List<AssignmentModel> searchByLikeName(String name);
	public void delete(AssignmentModel assignmentModel);
	public void hold(AssignmentModel assignmentModel);
	public void markAsDone(AssignmentModel assignmentModel);
}
