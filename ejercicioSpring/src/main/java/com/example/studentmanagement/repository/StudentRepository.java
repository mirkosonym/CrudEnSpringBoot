package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Estudiante
 * Proporciona operaciones CRUD básicas heredadas de JpaRepository
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
} 