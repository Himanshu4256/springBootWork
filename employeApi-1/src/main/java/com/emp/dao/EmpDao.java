package com.emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Employee;
import java.util.List;


public interface EmpDao extends JpaRepository<Employee,Long> {
	
	Employee findById(long id);
}