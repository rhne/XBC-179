package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.OfficeModel;

public interface OfficeService {
	public OfficeModel create(OfficeModel officeModel);
	public List<OfficeModel> searchAll();
	public List<OfficeModel> searchByLikeName(String name);
	public OfficeModel searchById(Long id);
	public void delete(OfficeModel officeModel);
	public void update(OfficeModel officeModel);
}
