package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.AssignmentModel;
import com.spring.miniproject.service.AssignmentService;

@Controller
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;
	
	/*Menu Assignment*/
	@RequestMapping(value="assignment")
	public String assignment(Model model) {
		String jsp = "assignment/assignment";
		return jsp;
	}
	
	@RequestMapping(value="assignment/list")
	public String listassignment(Model model) {
		List<AssignmentModel> assignmentModelList = new ArrayList<AssignmentModel>();
		assignmentModelList = this.assignmentService.searchAll();
		model.addAttribute("assignmentModelList", assignmentModelList);
		String jsp = "assignment/list";
		return jsp;
	}
}
