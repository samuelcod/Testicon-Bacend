package com.testicon.service;

import java.util.List;

import com.testicon.model.Admin;

public interface AdminService {
	List<Admin> findAll();
	boolean exist(Admin admin);
	Admin save(Admin admin);
}
