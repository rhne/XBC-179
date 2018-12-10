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
import com.spring.miniproject.service.AssignmentService;
import com.spring.miniproject.service.BiodataService;

@Controller
public class AssignmentController extends BaseController {

	@Autowired
	private AssignmentService assignmentService;

	@Autowired
	private BiodataService biodataService;

	/* Menu Assignment */
	@RequestMapping(value = "assignment")
	public String assignment(Model model) {
		String jsp = "assignment/assignment";
		return jsp;
	}

	/* List Assignment */
	@RequestMapping(value = "assignment/list")
	public String listassignment(Model model) {
		List<AssignmentModel> assignmentModelList = new ArrayList<AssignmentModel>();
		assignmentModelList = this.assignmentService.searchAll();
		model.addAttribute("assignmentModelList", assignmentModelList);
		String jsp = "assignment/list";
		return jsp;
	}

	/* Popup Add Assignment */
	@RequestMapping(value = "assignment/tambah")
	public String tambahassignment(Model model) {

		this.listbiodata(model);

		String jsp = "assignment/tambah";
		return jsp;
	}

	/* List Biodata for Name Dropdown */
	private void listbiodata(Model model) {
		// TODO Auto-generated method stub
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = this.biodataService.searchAll();
		model.addAttribute("biodataModelList", biodataModelList);
	}

	/* Create Assignment */
	@RequestMapping(value = "assignment/create")
	public String create(HttpServletRequest request, Model model) throws Exception {

		/* id String(input) to id Long */
		Long id = Long.valueOf(request.getParameter("testId"));

		/* string date value to date object with format */
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

	/* Search Assignment By Biodata Name */
	@RequestMapping(value = "assignment/search/name")
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

	/* Popup Hold Assignment */
	@RequestMapping(value = "assignment/hold")
	public String hold(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");

		AssignmentModel assignmentModel = new AssignmentModel();
		assignmentModel = this.assignmentService.searchById(Long.parseLong(id));
		model.addAttribute("assignmentModel", assignmentModel);

		String jsp = "assignment/hold";
		return jsp;
	}

	/* Hold Assignment */
	@RequestMapping(value = "assignment/hold/save")
	public String assignmentHold(HttpServletRequest request) {

		Long id = Long.valueOf(request.getParameter("id"));

		AssignmentModel assignmentModel = new AssignmentModel();
		assignmentModel = this.assignmentService.searchById(id);
		this.assignmentService.hold(assignmentModel);

		String jsp = "assignment/assignment";
		return jsp;
	}

	/* Popup Mark As Done Assignment */
	@RequestMapping(value = "assignment/done")
	public String assignmentDone(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		AssignmentModel assignmentModel = new AssignmentModel();
		assignmentModel = this.assignmentService.searchById(id);
		model.addAttribute("assignmentModel", assignmentModel);

		String jsp = "assignment/done";
		return jsp;
	}

	/* Mark As Done Assignment */
	@RequestMapping(value = "assignment/done/save")
	public String assignmentDoneSave(HttpServletRequest request, Model model) throws Exception {
		Long id = Long.valueOf(request.getParameter("id"));

		AssignmentModel assignmentModelDB = new AssignmentModel();
		assignmentModelDB = this.assignmentService.searchById(id);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date realizationDate = sdf.parse(request.getParameter("realizationDate"));

		assignmentModelDB.setRealizationDate(realizationDate);
		assignmentModelDB.setNotes(request.getParameter("notes"));

		this.assignmentService.update(assignmentModelDB);
		model.addAttribute("assignmentModelDB", assignmentModelDB);

		String jsp = "assignment/assignment";
		return jsp;
	}

	/* Popup Edit Assignment */
	@RequestMapping(value = "assignment/edit")
	public String assignmentEdit(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		AssignmentModel assignmentModel = new AssignmentModel();
		assignmentModel = this.assignmentService.searchById(id);
		model.addAttribute("assignmentModel", assignmentModel);

		String jsp = "assignment/edit";
		return jsp;
	}

	/* Edit Assignment */
	@RequestMapping(value = "assignment/edit/save")
	public String assignmentEditSave(HttpServletRequest request, Model model) throws Exception {
		Long id = Long.valueOf(request.getParameter("id"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(request.getParameter("startDate"));
		Date endDate = sdf.parse(request.getParameter("endDate"));

		AssignmentModel assignmentModelDB = new AssignmentModel();
		assignmentModelDB = this.assignmentService.searchById(id);

		assignmentModelDB.setTitle(request.getParameter("title"));
		assignmentModelDB.setStartDate(startDate);
		assignmentModelDB.setEndDate(endDate);
		assignmentModelDB.setDescription(request.getParameter("description"));

		this.assignmentService.update(assignmentModelDB);
		model.addAttribute("assignmentModelDB", assignmentModelDB);

		String jsp = "assignment/assignment";
		return jsp;
	}
}
