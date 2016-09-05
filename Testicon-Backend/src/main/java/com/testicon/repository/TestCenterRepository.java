package com.testicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testicon.model.TestCenter;

@Repository("testCenterRepository")
public interface TestCenterRepository extends JpaRepository<TestCenter, Long> {

}
