package com.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
