package com.testicon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testicon.model.Admin;
import com.testicon.repository.AdminRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin findByAdminId(long id) {
		// TODO Auto-generated method stub
		return adminRepository.findByAdminId(id);
	}

	
	/*@Override
	public boolean exist(Admin admin) {
		// TODO Auto-generated method stub
		if(adminRepository.findByEmail(admin.getEmail()) != null) {
			return true;
		} 
		return false;
	}

	@Override
	public Admin save(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.saveAndFlush(admin);
	}
*/
}
