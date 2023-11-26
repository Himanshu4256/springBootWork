package com.student.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.api.model.Student;

public interface StudentDao  extends JpaRepository<Student, Long>{

}
