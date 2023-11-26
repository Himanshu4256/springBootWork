package com.college.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import com.college.advice.BaseResponse;
import com.college.dao.DepartmentRepository;
import com.college.dao.TeacherRepository;
import com.college.entities.Department;
import com.college.entities.LogIn;
import com.college.entities.Teacher;
import com.fasterxml.jackson.annotation.JsonInclude;

@Service
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	
	public Department saveDepartment(Long teacherId, Department department) {
		
		Optional<Teacher> teacher = teacherRepository.findById(teacherId);
		if (teacher != null) {
			department.setTeacherId(teacherId);
		}
		return departmentRepo.save(department);
	}
	
	public Department updateDepartment(Long id, Department dept) {
		Optional<Department> findId = departmentRepo.findById(id);
		dept.setDeptId(id);
		Department save = null;
		if(findId != null) {
			 save = departmentRepo.save(dept);
		}
		return save;
	}
	
	
	
	public ResponseEntity<?> findDepartMentById(Long id){ 
		BaseResponse<Department> response = new BaseResponse<>();
		Department department =  departmentRepo.findById(id).orElse(null);
		if (department != null) {
			Optional<Teacher> teacher = teacherRepository.findById(department.getDeptId());
			String teacherName = teacher.get().getName();
			
			response.setMessage("Data Found Successfully");
			response.setStatus("200");
			response.setData(department);
			response.setTeacherName(teacherName);
//			response.setClassName(className);
		}
		return new ResponseEntity<>(response,HttpStatus.OK); 
	}
}