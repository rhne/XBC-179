package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.MonitoringModel;
import com.spring.miniproject.service.MonitoringService;

@Controller
public class MonitoringController {

	@Autowired
	private MonitoringService monitoringService;
	
	/*Menu Monitoring*/
	@RequestMapping(value="monitoring")
	public String monitoring(Model model) {
		String jsp = "monitoring/monitoring";
		return jsp;
	}
	
	@RequestMapping(value="monitoring/list")
	public String listmonitoring(Model model) {
		List<MonitoringModel> monitoringModelList = new ArrayList<MonitoringModel>();
		monitoringModelList = this.monitoringService.searchAll();
		model.addAttribute("monitoringModelList", monitoringModelList);
		String jsp = "monitoring/list";
		return jsp;
	}
}
