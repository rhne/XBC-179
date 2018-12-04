package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.AkunModel;
import com.spring.miniproject.model.BiodataModel;
import com.spring.miniproject.service.BiodataService;

@Controller
public class BiodataController {

	@Autowired
	private BiodataService biodataService;
	
	/*Menu Biodata*/
	@RequestMapping(value="biodata")
	public String biodata(Model model) {
		String jsp = "biodata/biodata";
		return jsp;
	}
	
	@RequestMapping(value="biodata/list")
	public String listbiodata(Model model) {
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = this.biodataService.searchAll();
		model.addAttribute("biodataModelList", biodataModelList);
		String jsp = "biodata/list";
		return jsp;
	}
	
	@RequestMapping(value="biodata/tambah")
	public String tambahbiodata(Model model) {
		
		this.listbiodata(model);
		
		String jsp = "biodata/tambah";
		return jsp;
	}
	
	@RequestMapping(value="biodata/create")
	public String create(HttpServletRequest request, Model model) throws Exception{
		
		BiodataModel biodataModel = new BiodataModel();
		biodataModel.setName(request.getParameter("name"));	
		biodataModel.setLastEducation(request.getParameter("lastEducation"));
		biodataModel.setEducationalLevel(request.getParameter("educationalLevel"));
		biodataModel.setGraduationYear(request.getParameter("graduationYear"));
		biodataModel.setMajors(request.getParameter("majors"));
		biodataModel.setGpa(request.getParameter("gpa"));
		biodataModel.setActive(1);
		
		this.biodataService.create(biodataModel);
		model.addAttribute("biodataModel", biodataModel);
		
		String jsp = "biodata/biodata";
		return jsp;
	}
}
