package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.RoomModel;

public interface RoomDao {
	public void create(RoomModel roomModel);
	public List<RoomModel> searchAll();
	public List<RoomModel> searchByLikeName(String name);
	public RoomModel searchById(Long id);
	public void delete(RoomModel roomModel);
}
