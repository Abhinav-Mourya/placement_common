package com.masai.service;

import java.util.List;

import com.masai.entities.Student;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;

public interface StudentService {

	
	public Student addStudent(Student student);
	
	public List<Student> getAllStudents() throws StudentException;
	
	public Student assignCourseToStudent(int uniqueId, String courseName) throws StudentException,CourseException;
	
	public List<Student> getStudentsByName(String name) throws StudentException;
	
	
	public List<Student> getStudentsAssignedToCourse(String courseName) throws StudentException,CourseException;
}
