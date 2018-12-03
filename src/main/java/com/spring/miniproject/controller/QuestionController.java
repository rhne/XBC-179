package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.QuestionModel;
import com.spring.miniproject.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping (value="question")
	public String home() {
		String jsp = "question/home";
		return jsp;
	}
	
	@RequestMapping (value="question/tambah")
	public String tambah() {
		String jsp = "question/tambah";
		return jsp;
	}
	
	@RequestMapping (value="question/list")
	public String list(Model model) {
		List<QuestionModel> questionModels = new ArrayList<QuestionModel>();
		questionModels = this.questionService.searchAll();
		model.addAttribute("questionModelList", questionModels);
		String jsp = "question/list";
		return jsp;
	}
	
	@RequestMapping (value="question/create")
	public String create(HttpServletRequest request) {
		String question = request.getParameter("question");
		QuestionModel questionModel = new QuestionModel();
		questionModel.setQuestion(question);
		questionModel.setCreatedOn(new Date());
		questionModel.setIsDelete(0);
		
		String jsp = "question/home";
		return jsp;
	}
	
}
