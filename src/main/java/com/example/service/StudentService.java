package com.example.service;

import java.util.List;

import com.example.entity.Student;

public interface StudentService {

	/**
	 * Saves a Student entity.
	 * 
	 * @return the saved Student
	 */
	Student saveStudent(Student student);

	/**
	 * Fetches the list of all Student entities.
	 * 
	 * @return a list of Student
	 */
	List<Student> fetchStudentList();

	/**
	 * Updates an existing Student entity.
	 * 
	 * @param Student   the student with updated information
	 * @param studentId the ID of the Student to update
	 * @return the updated Student
	 */
	Student updateStudent(Student student, Long studentId);

	/**
	 * Deletes a Student entity by its ID.
	 * 
	 * @param studentId the ID of the student to delete
	 */
	void deleteStudentById(Long StudentId);

}
