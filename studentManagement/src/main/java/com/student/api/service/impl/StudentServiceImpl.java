package com.student.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.api.dao.StudentDao;
import com.student.api.model.Student;
import com.student.api.response.MsgResponse;
import com.student.api.response.StudentRequest;
import com.student.api.service.StudentService;
@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public MsgResponse saveStudent(StudentRequest studentRequest) {
		MsgResponse response = new MsgResponse();
		
		try {
			Student s = new Student();
			s.setName(studentRequest.getName());
			s.setRollno(studentRequest.getRollno());
			s.setAge(studentRequest.getAge());
			s.setMobileNumber(studentRequest.getMobileNumber());
			s.setAddress(studentRequest.getAddress());
			 Student save = studentDao.save(s);
			 
			 response.setData(save.getId());
			 response.setMessage("Student Saved");
			 response.setStatus(200);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public MsgResponse fetchStudent (StudentRequest strudentRequest) {
		MsgResponse res = new MsgResponse();
		
		try {
			Optional<Student> findById = studentDao.findById( Long.valueOf(strudentRequest.getId()));
			if(findById.isPresent()) {
				Student student = findById.get();   // ye optional class ka ek method hota hai agr db m data hota hi to ye use return kr deta hai otherwise Exception through kr deta hai.
				res.setStatus(200);
				res.setMessage("data found");
				res.setData(student);
			}
			else {
				res.setStatus(400);
				res.setMessage("data not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public MsgResponse fetchAllStudents (StudentRequest strudentRequest) {
		MsgResponse res = new MsgResponse();
		
		try {
			List<Student> findAll = studentDao.findAll();
			if(!findAll.isEmpty()) {
				res.setStatus(200);
				res.setMessage("data found");
				res.setData(findAll);
			}
			else {
				res.setStatus(400);
				res.setMessage("data not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	@Override
	public MsgResponse updateStudent (StudentRequest strudentRequest) {
		MsgResponse res = new MsgResponse();
		
		try {
			// Sbse pehle Update krne k liye Ham datafind krenge.
			Optional<Student> findById = studentDao.findById( Long.valueOf(strudentRequest.getId()));
			if(findById.isPresent()) {
				Student student = findById.get(); // if present to get kia.
				student.setName(strudentRequest.getName());
				student.setRollno(strudentRequest.getRollno());
				
				Student save = studentDao.save(student);
				
				 res.setData(save.getId());
				 res.setMessage("Student Update");
				 res.setStatus(200);

				
			}
			else {
				res.setStatus(400);
				res.setMessage("data not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public MsgResponse deleteStudent(StudentRequest studentRequest) {
		MsgResponse res = new MsgResponse();
	
		try {
			 studentDao.deleteById(Long.valueOf(studentRequest.getId()));
			 res.setMessage("Student Deleted");
			 res.setStatus(200);
			}
			
 catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	

}
