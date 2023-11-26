package com.college.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull()
	@Size(min=4, message = "Your name must be 4 character")
    private String name;
    
    @Column(unique = true)
    private String rollNo;
    
    @NotBlank(message = "your address should not blank")
    private String address;
    
    @Size(min = 10, max = 10, message = "Your number should be 10 digits")
    @Column(unique = true)
    private String mobileNumber;
    
	private Long studentClassId;
	private Long teacherId;
	
}
