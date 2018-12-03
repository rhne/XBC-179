package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.BiodataModel;

public interface BiodataDao {
	public void create(BiodataModel biodataModel);
	public List<BiodataModel> searchAll();
}
