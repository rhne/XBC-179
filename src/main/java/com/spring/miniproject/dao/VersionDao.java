package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.VersionModel;

public interface VersionDao {
	
	public List<VersionModel> searchAll();
	public void create(VersionModel versionModel);
	public VersionModel searchById(Long id);
	public void update(VersionModel versionModel);
	public void delete(VersionModel versionModel);
	
}
