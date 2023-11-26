package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.entities.Department;
import com.college.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/saveDept/{teacherId}")
	public ResponseEntity<String> saveDepartment(@PathVariable("teacherId") Long teacherId, @RequestBody Department d1) {
		Department saveDepartment = departmentService.saveDepartment(teacherId,d1);
		return ResponseEntity.ok("your department is saved :" + saveDepartment.getDeptId());
	}
	
	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/{id}")
	public ResponseEntity<?> findDepartmentById(@PathVariable Long id) {
		return departmentService.findDepartMentById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/Update/{deptId}")
	public ResponseEntity<?> updateDept(@PathVariable("deptId") Long deptId, @RequestBody Department dept){
		Department updateDepartment = departmentService.updateDepartment(deptId, dept);
		return ResponseEntity.ok("your data is updated of ID :" + updateDepartment.getDeptId());
	}
}