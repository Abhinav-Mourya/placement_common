package com.masai.service;

import java.util.List;

import com.masai.entities.Course;
import com.masai.exceptions.CourseException;

public interface CourseService {
	
	public Course addCourse(Course course);
	
	public List<Course> getAllCourses() throws CourseException;

}
