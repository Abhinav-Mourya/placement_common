package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Course;
import com.masai.exceptions.CourseException;
import com.masai.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/addCourse")
	public ResponseEntity<Course> addCourseHandler(@RequestBody Course course) {
		
		Course c=courseService.addCourse(course);
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getAllCourses")
	public ResponseEntity<List<Course>> getAllCoursesHandler() throws CourseException{
		
		List<Course> arr=courseService.getAllCourses();
		return new ResponseEntity<>(arr,HttpStatus.ACCEPTED);
	}	

}
