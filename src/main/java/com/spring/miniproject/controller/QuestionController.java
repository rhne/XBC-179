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
	
	@RequestMapping (value="question/search/question")
	public String searchQuestion(HttpServletRequest request, Model model) {
		String searchString = request.getParameter("search");
		List<QuestionModel> questionModels = new ArrayList<QuestionModel>();
		questionModels = this.questionService.searchByLikeQuestion(searchString);
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
		this.questionService.create(questionModel);
		
		String jsp = "question/home";
		return jsp;
	}
	
	@RequestMapping (value="question/delete")
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		QuestionModel questionModel = new QuestionModel();
		questionModel = this.questionService.searchById(Long.parseLong(id));
		model.addAttribute("questionModel", questionModel);
		String jsp = "question/delete";
		return jsp;
	}
	
	@RequestMapping (value="question/delete/save")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		QuestionModel questionModel = new QuestionModel();
		questionModel = this.questionService.searchById(Long.parseLong(id));
		this.questionService.delete(questionModel);
		
		String jsp = "question/home";
		return jsp;
	}
	
}
