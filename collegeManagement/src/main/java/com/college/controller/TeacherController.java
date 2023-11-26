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

import com.college.entities.Teacher;
import com.college.service.TeacherService;

import jakarta.validation.Valid;

@RequestMapping("/api/teachers")
@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/saveTeacher")
	public String saveTeacherDetails(@Valid @RequestBody Teacher t1) {
		teacherService.saveTeacher(t1);
		return "Teacher Saved";
	}
	
	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/{id}")
	public ResponseEntity<?> findTeacherById(@PathVariable Long id) {
		return teacherService.findTeacherById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/UpdateTeacher/{id}")
	public ResponseEntity<?> updateTeacherById(@Valid @PathVariable("id") Long tId,@RequestBody Teacher tl){
		Teacher updatetcr = teacherService.updateTeacher(tId, tl);
		return ResponseEntity.ok("Your data is updated of Id :" +updatetcr.getId());
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("deleteTeacher/{id}")
	public ResponseEntity<?> deleteTeacherById(@PathVariable("id") Long id, @RequestBody Teacher s){
		teacherService.deleteTeacherDetails(id, s);
		return ResponseEntity.ok("Your Teacher is deleted with ID :"+s.getId());
	}
}