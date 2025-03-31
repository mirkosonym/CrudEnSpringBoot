package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que define las operaciones disponibles para la gestión de estudiantes
 */
public interface StudentService {
    /**
     * Obtener todos los estudiantes
     */
    List<Student> getAllStudents();
    
    /**
     * Buscar un estudiante por su ID
     */
    Optional<Student> getStudentById(Long id);
    
    /**
     * Crear un nuevo estudiante
     */
    Student createStudent(StudentDTO studentDTO);
    
    /**
     * Actualizar un estudiante existente
     */
    Student updateStudent(Long id, StudentDTO studentDTO);
    
    /**
     * Eliminar un estudiante por su ID
     */
    void deleteStudent(Long id);
} 