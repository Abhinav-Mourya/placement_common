package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{
     
	public Course findByCourseName(String name);
}
