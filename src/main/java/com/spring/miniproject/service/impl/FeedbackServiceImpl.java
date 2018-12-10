package com.spring.miniproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.FeedbackDao;
import com.spring.miniproject.model.FeedbackModel;
import com.spring.miniproject.service.FeedbackService;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;
	
	@Override
	public FeedbackModel create(FeedbackModel feedbackModel) {
		return this.create(feedbackModel);
	}

}
