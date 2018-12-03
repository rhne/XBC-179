package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.QuestionModel;

public interface QuestionDao {
	
	public List<QuestionModel> searchAll();
	
}
