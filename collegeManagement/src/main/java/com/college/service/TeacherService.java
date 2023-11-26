package com.college.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.advice.BaseResponse;
import com.college.dao.TeacherRepository;
import com.college.entities.Student;
import com.college.entities.StudentClass;
import com.college.entities.Teacher;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public Teacher saveTeacher(Teacher t){
		return teacherRepository.save(t);
	}
	
	public ResponseEntity<?> findTeacherById(Long id) {
		BaseResponse<Teacher> response = new BaseResponse();
		Teacher teacher = teacherRepository.findById(id).orElse(null);
//		if (teacher != null) {
//			Optional<Teacher> teacher = teacherRepository.findById(student.getTeacherId());
//			String teacherName = teacher.get().getName();
//
//			Optional<StudentClass> cls = classRepository.findById(student.getStudentClassId());
//			String className = cls.get().getClassName();
//
//			response.setMessage("Data Found Successfully");
//			response.setStatus("200");
//			response.setData(student);
//			response.setTeacherName(teacherName);
//			response.setClassName(className);
//		}
//		 
//		return new ResponseEntity<>(response, HttpStatus.OK);
		
		return new ResponseEntity<>(teacher, HttpStatus.OK);
	}
	
	public Teacher updateTeacher(Long id, Teacher T) {
		 Optional<Teacher> findIdOptional = teacherRepository.findById(id);
		 T.setId(id);
		 Teacher teacher = null;
		 if (findIdOptional != null) {
			 teacher = teacherRepository.save(T);
		}
		 return teacher;
	 }
	
	
	 public void deleteTeacherDetails(Long id, Teacher st) {
		 if (id <= 0) {
			throw new IllegalArgumentException("Invalid user ID");
		}
		 teacherRepository.deleteById(id);
	 }
}