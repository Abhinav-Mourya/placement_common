package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	public List<Student>findByName(String name);

}
