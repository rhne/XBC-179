package com.spring.miniproject.controller;

import java.util.ArrayList;     
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.AkunModel;
import com.spring.miniproject.model.OfficeModel;
import com.spring.miniproject.model.QuestionModel;
import com.spring.miniproject.service.OfficeService;

@Controller
public class OfficeController {

	@Autowired
	private OfficeService officeService;
	
	@RequestMapping(value="office")
	public String user(Model model) {
		String jsp = "office/office";
		return jsp;
	}
	
	@RequestMapping(value="office/tambah")
	public String tambahoffice(Model model) {
		
		String jsp = "office/tambah";
		return jsp;
	}	
		
	
	@RequestMapping(value="office/create")
	public String create(HttpServletRequest request, Model model) throws Exception{
		
		OfficeModel officeModel = new OfficeModel();
		officeModel.setName(request.getParameter("name"));		
		officeModel.setPhone(request.getParameter("phone"));
		officeModel.setEmail(request.getParameter("email"));
		officeModel.setAddress(request.getParameter("address"));
		officeModel.setNotes(request.getParameter("notes"));
		officeModel.setIsActive(1);
		
		this.officeService.create(officeModel);
		model.addAttribute("officeModel", officeModel);
		
		String jsp = "office/office";
		return jsp;
	}
	
	@RequestMapping(value="office/list")
	public String listoffice(Model model) {
		List<OfficeModel> officeModelList = new ArrayList<OfficeModel>();
		officeModelList = this.officeService.searchAll();
		model.addAttribute("officeModelList", officeModelList);
		String jsp = "office/list";
		return jsp;
	}
	@RequestMapping(value="office/search/name")
	public String officeSearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<OfficeModel> officeModelList = new ArrayList<OfficeModel>();
		officeModelList = this.officeService.searchByLikeName(name);
		model.addAttribute("officeModelList", officeModelList);
		String jsp = "office/list";
		return jsp;
	}
	@RequestMapping (value="office/delete")
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		OfficeModel officeModel = new OfficeModel();
		officeModel = this.officeService.searchById(Long.parseLong(id));
		model.addAttribute("officeModel", officeModel);
		String jsp = "office/delete";
		return jsp;
	}
	
	@RequestMapping (value="office/delete/save")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		OfficeModel officeModel = new OfficeModel();
		officeModel = this.officeService.searchById(Long.parseLong(id));
		this.officeService.delete(officeModel);
		
		String jsp = "office/office";
		return jsp;
	}
}
