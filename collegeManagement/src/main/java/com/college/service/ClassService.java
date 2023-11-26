package com.college.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.dao.ClassRepository;
import com.college.entities.StudentClass;


@Service
public class ClassService {
	 @Autowired
	    private ClassRepository classRepository;
	 
	 public Optional<StudentClass> findById(Long id) {
	    	return classRepository.findById(id);
	    }
	 
	 
	 public StudentClass saveSection(StudentClass cls) {
	    	return classRepository.save(cls);
	    }
	    
	 public StudentClass updateClass(Long id, StudentClass sc) {
		 Optional<StudentClass> findIdOptional = classRepository.findById(id);
		 sc.setId(id);
		 StudentClass clas = null;
		 if (findIdOptional != null) {
			clas = classRepository.save(sc);
		}
		 return clas;
	 }
	 
	 
	 public void deleteClassDetails(Long id, StudentClass cls) {
		 if (id <= 0) {
			throw new IllegalArgumentException("Invalid user ID");
		}
		 classRepository.deleteById(id);
	 }
	 
//	 public void deleteUserById(Long classId) {
//	        // Validate input
//	        if (classId <= 0) {
//	            throw new IllegalArgumentException("Invalid user ID");
//	        }
//
//	        try {
//	            // Attempt to delete the user
//	            classRepository.deleteById(classId);
//	            // Log success
//	            log.info("Class with ID {} deleted successfully.", classId);
//	        } catch (EmptyResultDataAccessException ex) {
//	            // Log not found exception
//	            log.error("Class with ID {} not found.", classId);
//	            // Rethrow as a custom exception
//	            throw new EntityNotFoundException("User not found");
//	        } catch (DataIntegrityViolationException ex) {
//	            // Log data integrity violation exception
//	            log.error("Class deleting user with ID {}: {}", classId, ex.getMessage());
//	            // Rethrow as a custom exception
//	            throw new DataIntegrityException("Error deleting user: " + ex.getMessage());
//
//}

}