package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;

import jakarta.transaction.Transactional;

import com.emp.dao.EmpDao;

@Service
public class EmpService {
	
	@Autowired
	EmpDao empDao;
	
	public String saveEmp(Employee e) {
		e.setName("Mayank");
		e.setAddress("delhi");
		empDao.save(e);
		return "Data Saved Successfully";
	}
	
	
	public List<Employee> fetchAllData() {
		return empDao.findAll();
	}
	
	
	
	public Employee fetchUsingId(long id) {
		return empDao.findById(id);
	}
	
	//Update
	public Employee updateEmployee(Employee emp) {
		return empDao.save(emp);
		
	}
	
	//delete
	public void deleteData(Long id) {
		empDao.deleteById(id);
	}
	
	
//	public User deleteUser(int id) {
//		User UUser = userRepo.deleteById(id);
//		return UUser;
//	}
	
}
 