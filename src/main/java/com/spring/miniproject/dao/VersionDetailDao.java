package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.VersionDetailModel;

public interface VersionDetailDao {
	
	public VersionDetailModel create(VersionDetailModel versionDetailModel);
	public List<VersionDetailModel> searchAll();
	
}
