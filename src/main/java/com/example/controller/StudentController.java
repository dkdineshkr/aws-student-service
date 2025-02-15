package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

import jakarta.validation.Valid;

/**
 * REST controller for managing Student entities. Handles HTTP requests and
 * routes them to the appropriate service methods.
 */
@RestController // Marks this class as a RESTful controller.
@RequestMapping("/studentmgmt")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * Handles POST requests to save a new Student.
	 * 
	 */
	@PostMapping("/student")
	public Student saveStudent(@Valid @RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	/**
	 * Handles GET requests to fetch the list of all students.
	 * 
	 */
	@GetMapping("/students")
	public List<Student> fetchStudentList() {
		return studentService.fetchStudentList();
	}

	/**
	 * Handles PUT requests to update an existing student.
	 * 
	 */
	@PutMapping("/students/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long studentId) {
		return studentService.updateStudent(student, studentId);
	}

	/**
	 * Handles DELETE requests to remove a student by ID.
	 * 
	 */
	@DeleteMapping("/students/{id}")
	public String deleteStudentsById(@PathVariable("id") Long studentId) {
		studentService.deleteStudentById(studentId);
		return "Deleted Successfully";
	}

}
