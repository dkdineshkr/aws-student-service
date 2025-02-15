package com.example.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		// save and returns the student entity
		return studentRepository.save(student);
	}

	@Override
	public List<Student> fetchStudentList() {
		// Retrieves and returns a list of all Student entities.
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, Long studentId) {
		// Finds the existing student by ID.
		Student studDB = studentRepository.findById(studentId).get();

		// Updates fields if they are not null or empty.
		if (Objects.nonNull(student.getFirstName()) && !"".equalsIgnoreCase(student.getFirstName())) {
			studDB.setFirstName(student.getFirstName());
		}
		if (Objects.nonNull(student.getLastName()) && !"".equalsIgnoreCase(student.getLastName())) {
			studDB.setLastName(student.getLastName());
		}
		if (Objects.nonNull(student.getAddress()) && !"".equalsIgnoreCase(student.getAddress())) {
			studDB.setAddress(student.getAddress());
		}
		if (Objects.nonNull(student.getDepartment()) && !"".equalsIgnoreCase(student.getDepartment())) {
			studDB.setDepartment(student.getDepartment());
		}

		// Saves and returns the updated Student entity.
		return studentRepository.save(studDB);
	}

	@Override
	public void deleteStudentById(Long StudentId) {
		// Deletes the Student entity by its ID.
		studentRepository.deleteById(StudentId);
	}

}
