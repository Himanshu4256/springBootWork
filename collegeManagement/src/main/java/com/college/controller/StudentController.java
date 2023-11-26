package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.entities.Student;
import com.college.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save/{teacherId}/{classId}")
	public ResponseEntity<String> saveStudent(@Valid @PathVariable("teacherId") Long teacherId, @PathVariable("classId") Long classId, @RequestBody Student student) {
		Student savedStudent = studentService.saveStudent(teacherId, classId, student);
		return ResponseEntity.ok("Student saved with ID: " + savedStudent.getId());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable Long id) {
		return studentService.findStudentById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/Update/{id}")
	public ResponseEntity<?> updateStudentById(@Valid @PathVariable("id") Long sId,@RequestBody Student sl){
		Student updateStu = studentService.updateStudent(sId, sl);
		return ResponseEntity.ok("Your data is updated of Id :" +updateStu.getId());
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long id, @RequestBody Student s){
		studentService.deleteStudentDetails(id, s);
		return ResponseEntity.ok("Your Student is deleted with ID :"+s.getId());
	}
}