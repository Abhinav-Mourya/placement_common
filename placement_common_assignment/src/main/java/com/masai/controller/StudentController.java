package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Student;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student student) {
		
		Student s=studentService.addStudent(student);
		return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudentsHandler() throws StudentException {
		
		List<Student> arr=studentService.getAllStudents();
		return new ResponseEntity<>(arr,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/assignCourseToStudent/{id}/{name}")
	public ResponseEntity<Student> assignCourseToStudent(@PathVariable Integer id, @PathVariable String name) throws StudentException, CourseException {
		
		Student st=studentService.assignCourseToStudent(id, name);
		return new ResponseEntity<>(st,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getStudentByName/{name}")
	public ResponseEntity<List<Student>> getStudentByNameHandler(@PathVariable String name) throws StudentException {
		
		List<Student> arr=studentService.getStudentsByName(name);
		return new ResponseEntity<>(arr,HttpStatus.ACCEPTED);
	}	
	
	
	@GetMapping("/getStudentsAssignedToCourse/{courseName}")
	public ResponseEntity<List<Student>> getStudentsAssignedToCourseHandler(@PathVariable String courseName) throws StudentException, CourseException{
		
		 List<Student> arr=studentService.getStudentsAssignedToCourse(courseName);
		 
		 return new ResponseEntity<>(arr,HttpStatus.ACCEPTED);
	}
	
}
