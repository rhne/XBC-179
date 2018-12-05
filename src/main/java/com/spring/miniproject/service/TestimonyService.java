package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.TestimonyModel;

public interface TestimonyService {

	public void create(TestimonyModel testimonyModel);
	public List<TestimonyModel> showAll();
	public List<TestimonyModel> searchBy(String title);
	public void edit(TestimonyModel testimonyModel);
	public TestimonyModel searchById(Long idTestimony);
}
