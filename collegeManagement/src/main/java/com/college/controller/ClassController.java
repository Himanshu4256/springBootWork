package com.college.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.dao.ClassRepository;
import com.college.entities.StudentClass;
import com.college.service.ClassService;

import jakarta.validation.Valid;

@RequestMapping("/api/classes")
@RestController
public class ClassController {

	@Autowired
	private ClassService classService;
	
	@Autowired
    private ClassRepository classRepository;

//	@PreAuthorize("hasRole('ADMIN')")
//	@PostMapping("/saveClass")
//	public String saveSection(@Valid @RequestBody StudentClass cs) {
//		classService.saveSection(cs);
//		return "Class saved";
//	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/saveClass/{cs}")
	public String saveSection(@Valid @PathVariable String cs) {
		StudentClass cls =new StudentClass(null, cs);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+cs);
		classRepository.save(cls);
		return "Class saved";
	}
	
	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/findClassById/{id}")
	public Optional<StudentClass> findById(@PathVariable("id") Long id) {
		return classService.findById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/Update/{id}")
	public ResponseEntity<?> updateClassById(@Valid @PathVariable("id") Long classId,@RequestBody StudentClass cl){
		StudentClass updateClass = classService.updateClass(classId, cl);
		return ResponseEntity.ok("Your data is updated of Id :" +updateClass.getId());
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteClass(@PathVariable("id") Long id, @RequestBody StudentClass s){
		classService.deleteClassDetails(id, s);
		return ResponseEntity.ok("Your class is deleted with ID :"+s.getId());
	}
	
}
