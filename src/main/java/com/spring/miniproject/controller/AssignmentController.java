package com.spring.miniproject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.AssignmentModel;
import com.spring.miniproject.model.BiodataModel;
import com.spring.miniproject.model.MonitoringModel;
import com.spring.miniproject.model.AssignmentModel;
import com.spring.miniproject.service.AssignmentService;
import com.spring.miniproject.service.BiodataService;

@Controller
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;
	
	@Autowired
	private BiodataService biodataService ;
	
	/*Menu Assignment*/
	@RequestMapping(value="assignment")
	public String assignment(Model model) {
		String jsp = "assignment/assignment";
		return jsp;
	}
	
	/*List Assignment*/
	@RequestMapping(value="assignment/list")
	public String listassignment(Model model) {
		List<AssignmentModel> assignmentModelList = new ArrayList<AssignmentModel>();
		assignmentModelList = this.assignmentService.searchAll();
		model.addAttribute("assignmentModelList", assignmentModelList);
		String jsp = "assignment/list";
		return jsp;
	}
	
	/*Popup Input Assignment*/
	@RequestMapping(value="assignment/tambah")
	public String tambahassignment(Model model) {
		
		this.listbiodata(model);
		
		String jsp = "assignment/tambah";
		return jsp;
	}
	
	/*List Biodata for Name Dropdown*/
	private void listbiodata(Model model) {
		// TODO Auto-generated method stub
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = this.biodataService.searchAll();
		model.addAttribute("biodataModelList", biodataModelList);
	}

	/*Create Assignment*/
	@RequestMapping(value="assignment/create")
	public String create(HttpServletRequest request, Model model) throws Exception{
		
		/*id String(input) to id Long*/
		Long id = Long.valueOf(request.getParameter("testId"));
		
		/*string date value to date object with format*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(request.getParameter("startDate"));
		Date endDate = sdf.parse(request.getParameter("endDate"));
		
		AssignmentModel assignmentModel = new AssignmentModel();
		assignmentModel.setTestId(id);
		assignmentModel.setTitle(request.getParameter("title"));
		assignmentModel.setStartDate(startDate);
		assignmentModel.setEndDate(endDate);
		assignmentModel.setDescription(request.getParameter("description"));
		assignmentModel.setIsHold(0);
		assignmentModel.setIsDelete(0);
		
		this.assignmentService.create(assignmentModel);
		model.addAttribute("assignmentModel", assignmentModel);
		
		String jsp = "assignment/assignment";
		return jsp;
	}
	
	@RequestMapping(value="assignment/search/name")
	public String assignmentSearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<AssignmentModel> assignmentModelList = new ArrayList<AssignmentModel>();
		assignmentModelList = this.assignmentService.searchByLikeName(name);
		model.addAttribute("assignmentModelList", assignmentModelList);
		String jsp = "assignment/list";
		return jsp;
	}
	
	/* Popup Delete Assignment */
	@RequestMapping(value = "assignment/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		
		AssignmentModel assignmentModel = new AssignmentModel();
		assignmentModel = this.assignmentService.searchById(Long.parseLong(id));
		model.addAttribute("assignmentModel", assignmentModel);
		
		String jsp = "assignment/delete";
		return jsp;
	}

	/* Delete Assignment */
	@RequestMapping(value = "assignment/delete/save")
	public String delete(HttpServletRequest request) {
		
		Long id = Long.valueOf(request.getParameter("id"));

		AssignmentModel assignmentModel = new AssignmentModel();
		assignmentModel = this.assignmentService.searchById(id);
		this.assignmentService.delete(assignmentModel);

		String jsp = "assignment/assignment";
		return jsp;
	}
}
