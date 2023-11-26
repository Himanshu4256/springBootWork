package com.student.api.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.api.response.MsgResponse;
import com.student.api.response.StudentRequest;
import com.student.api.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
		@PostMapping("saveStudent")
		public ResponseEntity<MsgResponse> saveStudent(@RequestBody StudentRequest studentRequest){
			MsgResponse response = new MsgResponse();
			
			try {
				response =  studentService.saveStudent(studentRequest);
			} catch ( Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		
		
		
		@GetMapping("fetchStudent")
		public ResponseEntity<MsgResponse> fetchStudent(@RequestBody StudentRequest studentRequest){
			MsgResponse response = new MsgResponse();
			
			try {
				response =  studentService.fetchStudent(studentRequest);
			} catch ( Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		
		
		
		@GetMapping("fetchAllStudents")
		public ResponseEntity<MsgResponse> fetchAllStudents(@RequestBody StudentRequest studentRequest){
			MsgResponse response = new MsgResponse();
			
			try {
				response =  studentService.fetchAllStudents(studentRequest);
			} catch ( Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		
		
		@PutMapping("updateStudent")
		public ResponseEntity<MsgResponse> updateStudent(@RequestBody StudentRequest studentRequest){
			MsgResponse response = new MsgResponse();
			
			try {
				response =  studentService.updateStudent(studentRequest);
			} catch ( Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		
		@DeleteMapping("deleteStudent")
		public ResponseEntity<MsgResponse> deleteStudent(@RequestBody StudentRequest studentRequest){
			MsgResponse response = new MsgResponse();
			
			try {
				response =  studentService.deleteStudent(studentRequest);
			} catch ( Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return new ResponseEntity<>(response,HttpStatus.OK);
		}

}
