package com.testicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testicon.model.Admin;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByAdminId(long id);
}
