package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.VersionModel;

public interface VersionService {
	
	public List<VersionModel> searchAll();
	public VersionModel create(VersionModel versionModel);
	public VersionModel searchById(Long id);
	public void update(VersionModel versionModel);
	public void delete(VersionModel versionModel);
	public Integer getLatestVersion();
	
}
