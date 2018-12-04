package com.spring.miniproject.controller;

import java.util.ArrayList;     
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.BootcampTestTypeModel;
import com.spring.miniproject.service.BootcampTestTypeService;

@Controller
public class BootcampTestTypeController {

	@Autowired
	private BootcampTestTypeService bootcamptesttypeService;
	
	@RequestMapping(value="bootcamp_test_type")
	public String bootcamptesttype(Model model) {
		String jsp = "bootcamp_test_type/bootcamp_test_type";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp_test_type/tambah")
	public String tambahbootcamptesttype(Model model) {
		
		String jsp = "bootcamp_test_type/tambah";
		return jsp;
	}	
	
	@RequestMapping(value="bootcamp_test_type/create")
	public String create(HttpServletRequest request, Model model) throws Exception{
		
		BootcampTestTypeModel bootcamptesttypeModel = new BootcampTestTypeModel();
		bootcamptesttypeModel.setName(request.getParameter("name"));		
		bootcamptesttypeModel.setNotes(request.getParameter("notes"));
		bootcamptesttypeModel.setIsActive(1);
		
		this.bootcamptesttypeService.create(bootcamptesttypeModel);
		model.addAttribute("bootcamptesttypeModel", bootcamptesttypeModel);
		
		String jsp = "bootcamp_test_type/bootcamp_test_type";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp_test_type/list")
	public String list(Model model) {
		List<BootcampTestTypeModel> bootcamptesttypeModelList = new ArrayList<BootcampTestTypeModel>();
		bootcamptesttypeModelList = this.bootcamptesttypeService.searchAll();
		model.addAttribute("bootcamptesttypeModelList", bootcamptesttypeModelList);
		String jsp = "bootcamp_test_type/list";
		return jsp;
	}
	
}