package com.spring.miniproject.controller;

import java.util.ArrayList;     
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.MenuModel;
import com.spring.miniproject.model.OfficeModel;
import com.spring.miniproject.model.RoomModel;
import com.spring.miniproject.service.MenuService;
import com.spring.miniproject.service.OfficeService;
import com.spring.miniproject.service.RoomService;
import com.spring.miniproject.service.SequenceService;

@Controller
public class RoomController extends BaseController{

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private OfficeService officeService;
	
	@Autowired
	private SequenceService sequenceService;
	
	public void aksesLogin(Model model) {
		
		model.addAttribute("username", this.getAkunModel().getName());
		model.addAttribute("nameRole", this.getAkunModel().getRoleModel().getName());
		
		List<MenuModel> menuModelList = null;
		Long idRole = this.getAkunModel().getRoleModel().getId();
		menuModelList = this.menuService.selectMenuByRole(idRole);
		model.addAttribute("menuModelList", menuModelList);
	}
	
	@RequestMapping(value="office/room")
	public String tambahroom(Model model) {
		this.aksesLogin(model);
		this.listDataOffice(model);
		String codeAuto = "";
		codeAuto = this.codeRoomGenerator();
		model.addAttribute("codeAuto", codeAuto);
		String jsp = "office/room";
		return jsp;
	}	
	
	@RequestMapping(value="office/tambah_room")
	public String tambahroombaru(HttpServletRequest request, Model model) {
		String id = "";
		id = request.getParameter("id");
		model.addAttribute("id", id);
		String jsp = "office/tambah_room";
		return jsp;
	}
	
	public void listRoom(Model model) {
		List<RoomModel> roomModelList = new ArrayList<RoomModel>();
		roomModelList = this.roomService.showAll();
		model.addAttribute("trainerModelList", roomModelList);
	}
	
	@RequestMapping(value="office/list_room")
	public String listroom(HttpServletRequest request, Model model) {
		Long id = new Long(request.getParameter("idOffice"));
		List<RoomModel> roomModelList = new ArrayList<RoomModel>();
		roomModelList = this.roomService.searchByIdOffice(id);
		model.addAttribute("roomModelList", roomModelList);
		
		this.listRoom(model);
		String jsp = "office/list_room";
		return jsp;
	}
	@SuppressWarnings("unused")
	private void listDataOffice(Model model) {
		List<OfficeModel> officeModelList = new ArrayList<OfficeModel>();
		officeModelList = this.officeService.searchAll();
		model.addAttribute("officeModelList", officeModelList);
	}
	
	@RequestMapping (value="office/delete_room")
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		RoomModel roomModel = new RoomModel();
		roomModel = this.roomService.searchById(Long.parseLong(id));
		model.addAttribute("roomModel", roomModel);
		String jsp = "office/delete_room";
		return jsp;
	}
	
	@RequestMapping (value="office/delete_room/save")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		RoomModel roomModel = new RoomModel();
		roomModel = this.roomService.searchById(Long.parseLong(id));
		this.roomService.delete(roomModel);
		
		String jsp = "office/office";
		return jsp;
	}
	
	public String codeRoomGenerator() {
		Integer idRoom = 0;
		idRoom = this.sequenceService.nextIdRoom();
		
		String codeAuto ="";
		if (idRoom < 10) {
			codeAuto = "R000" + idRoom;
		}else if (idRoom >= 10 && idRoom < 100) {
			codeAuto = "R00" + idRoom;
		}else if (idRoom >= 100 && idRoom < 1000) {
			codeAuto = "R0" + idRoom;
		}else if (idRoom >=1000) {
			codeAuto = "R" + idRoom;
		}else {
			
		}
		
		return codeAuto;
	}
	//edit
		@RequestMapping(value="office/edit_room")
		public String Edit(HttpServletRequest request, Model model) {
			String id = (request.getParameter("id"));
			RoomModel roomModel = new RoomModel();
			roomModel = this.roomService.searchById(Long.parseLong(id));
			model.addAttribute("roomModel", roomModel);
			String jsp = "office/edit_room";
			return jsp;
		}
		
		@RequestMapping(value="office/edit_room/save")
		public String EditSave(HttpServletRequest request, Model model) throws Exception{
			String id = request.getParameter("id");
			RoomModel roomModel = new RoomModel();
			roomModel = this.roomService.searchById(Long.parseLong(id));		
			roomModel.setCode(request.getParameter("code"));
			roomModel.setName(request.getParameter("name"));
			roomModel.setCapacity(Integer.parseInt(request.getParameter("capacity")));
			roomModel.setProjector(Integer.parseInt(request.getParameter("projector")));
			roomModel.setNotes(request.getParameter("notes"));
			Long modifiedBy = this.getAkunModel().getId();
			roomModel.setModifiedBy(modifiedBy);
			
			this.roomService.update(roomModel);
			model.addAttribute("roomModel", roomModel);
			
			String jsp = "office/edit";
			return jsp;
		}
}
