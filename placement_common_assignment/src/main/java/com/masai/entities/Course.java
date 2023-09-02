package com.masai.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer courseId;
	private String courseName;
	private String description;
	private Integer duration;
	private List<String> topics;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Student> student;
	
	

}
