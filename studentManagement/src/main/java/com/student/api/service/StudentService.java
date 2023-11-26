package com.student.api.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.api.model.Student;
import com.student.api.response.MsgResponse;
import com.student.api.response.StudentRequest;

public interface StudentService {

	MsgResponse saveStudent(StudentRequest studentRequest);
	MsgResponse fetchStudent(StudentRequest studentRequest);
	MsgResponse fetchAllStudents(StudentRequest studentRequest);
    MsgResponse updateStudent(StudentRequest studentRequest);
	MsgResponse deleteStudent(StudentRequest studentRequest);
    
}