package com.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entities.StudentClass;

public interface ClassRepository extends JpaRepository<StudentClass,Long>{

}
