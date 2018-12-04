package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
