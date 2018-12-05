package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.model.RoomModel;

public interface RoomService {
	public void create(RoomModel roomModel);
	public List<RoomModel> searchAll();
	public List<RoomModel> searchByLikeName(String name);
	public RoomModel searchById(Long id);
	public void delete(RoomModel roomModel);
}
