package com.masai.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer unique_student_code;
	private String name;
	private LocalDate dob;
	private Gender gender;
	
	@Embedded
	@ElementCollection
	private List<StudentAddress> studentAddress;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="student")
	private List<Course> course;

}
