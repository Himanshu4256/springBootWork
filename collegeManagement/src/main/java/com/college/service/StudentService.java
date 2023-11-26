package com.college.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.college.advice.BaseResponse;
import com.college.dao.ClassRepository;
import com.college.dao.StudentRepositiry;
import com.college.dao.TeacherRepository;
import com.college.entities.Student;
import com.college.entities.StudentClass;
import com.college.entities.Teacher;

@Service
public class StudentService {

	@Autowired
	private StudentRepositiry studentRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private ClassRepository classRepository;

	public Student saveStudent(Long teacherId, Long classId, Student student) {

		Optional<Teacher> teacher = teacherRepository.findById(teacherId);
		if (teacher != null) {
			student.setTeacherId(teacherId); // if teacher is not null then. If it contains a valid Teacher object, it sets the teacherId on the Department object d. 
		}

		Optional<StudentClass> studentClass = classRepository.findById(classId);
		if (studentClass != null) {
			student.setStudentClassId(classId);
		}

		return studentRepository.save(student);
	}

	public ResponseEntity<?> findStudentById(Long id) {
		BaseResponse<Student> response = new BaseResponse();
		Student student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			Optional<Teacher> teacher = teacherRepository.findById(student.getTeacherId());
			String teacherName = teacher.get().getName();

			Optional<StudentClass> cls = classRepository.findById(student.getStudentClassId());
			String className = cls.get().getClassName();

			response.setMessage("Data Found Successfully");
			response.setStatus("200");
			response.setData(student);
			response.setTeacherName(teacherName);
			response.setClassName(className);
		}
		 
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	//	return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	public Student updateStudent(Long id, Student sc) {
		 Optional<Student> findIdOptional = studentRepository.findById(id);
		 sc.setId(id);
		 Student student = null;
		 if (findIdOptional != null) {
			 student = studentRepository.save(sc);
		}
		 return student;
	 }
	
	
	 public void deleteStudentDetails(Long id, Student st) {
		 if (id <= 0) {
			throw new IllegalArgumentException("Invalid user ID");
		}
		 classRepository.deleteById(id);
	 }
}
