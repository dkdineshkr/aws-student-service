package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;

/**
 * Repository interface for Student entity. Provides CRUD operations and custom
 * query methods through JpaRepository.
 */
@Repository // Indicates that this interface is a Spring Data repository.
public interface StudentRepository extends JpaRepository<Student, Long> {

}
