package com.student.api.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student_management")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String age;
	@Column(name = "mobile_number")
	private String mobileNumber;
	private String address;
	@Column(name = "roll_no")
	private String rollno;
	
	@CreationTimestamp 						//ye  date ko automatically create kr dega. joki DB m hogi. jab record save hoga us time ki.
	@Column(name = "created_Date")
	private LocalDateTime createdDate;
	

}
