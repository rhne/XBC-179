package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.AssignmentModel;

public interface AssignmentService {
	public void create(AssignmentModel assignmentModel);
	public List<AssignmentModel> searchAll();
}
