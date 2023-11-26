package com.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entities.Student;

public interface StudentRepositiry extends JpaRepository<Student, Long> {

}
