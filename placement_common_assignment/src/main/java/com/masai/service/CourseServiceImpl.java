package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Course;
import com.masai.exceptions.CourseException;
import com.masai.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
    
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	@Override
	public Course addCourse(Course course) {
		
		return courseRepository.save(course);
	}



	@Override
	public List<Course> getAllCourses() throws CourseException {
	     
		List<Course> arr=courseRepository.findAll();
		
		
		if(arr.size()!=0)
		{
			return arr;
		}
		else
		{
			throw new CourseException("No course found");
		}
	}

}
