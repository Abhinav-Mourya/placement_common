package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Course;
import com.masai.entities.Student;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.repository.CourseRepository;
import com.masai.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
   
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student assignCourseToStudent(int uniqueId, String courseName) throws StudentException, CourseException{
		
		
		Optional<Student> op=studentRepository.findById(uniqueId);
		
		if(op.isEmpty()==false)
		{
			Student st=op.get();
			
			List<Course> x=st.getCourse();
			
			for(int i=0;i<x.size();i++)
			{
				if(x.get(i).getCourseName().equals(courseName))
				{
					throw new CourseException("course already exists");
				}
			}
			
			
			Course c=courseRepository.findByCourseName(courseName);
			
			if(c!=null)
			{
				st.getCourse().add(c);
				c.getStudent().add(st);
				
				courseRepository.save(c);
				
				return st;
			}
			else
			{
				throw new CourseException("no course found with this name");
			}
			 
		}
		else
		{
			throw new StudentException("No student found with this unique id");
		}
	}

	
	@Override
	public List<Student> getAllStudents() throws StudentException {
		
		List<Student> arr=studentRepository.findAll();
		
		if(arr.size()!=0)
		{
			return arr;
			
		}
		else
		{
			throw new StudentException("No student found");
		}
	}

	@Override
	public List<Student> getStudentsByName(String name) throws StudentException {
		
		List<Student>arr=studentRepository.findByName(name);
		
		if(arr.size()!=0)
		{
			return arr;
		}
		else
		{
			throw new StudentException("No student found with this name");
		}
	}

	@Override
	public List<Student> getStudentsAssignedToCourse(String courseName) throws StudentException, CourseException {
		
		Course c=courseRepository.findByCourseName(courseName);
		
		if(c==null)
		{
			throw new CourseException("no course exist with this name");
		}
		else
		{
			List<Student> arr=c.getStudent();
			
			if(arr.size()!=0)
			{
				return arr;
			}
			else
			{
				throw new StudentException("No student found in this course");
			}
		}
	}

}
