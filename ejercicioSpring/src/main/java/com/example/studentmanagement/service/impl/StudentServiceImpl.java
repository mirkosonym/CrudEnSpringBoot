package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.dto.StudentDTO;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de estudiantes
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student createStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, StudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con id: " + id));
        
        // Actualizar el estudiante existente con los valores del DTO
        existingStudent.setNombre(studentDTO.getNombre());
        existingStudent.setApellido(studentDTO.getApellido());
        existingStudent.setEmail(studentDTO.getEmail());
        existingStudent.setEdad(studentDTO.getEdad());
        existingStudent.setCarrera(studentDTO.getCarrera());
        
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Estudiante no encontrado con id: " + id);
        }
        studentRepository.deleteById(id);
    }
    
    /**
     * Convierte un DTO a una entidad
     */
    private Student convertToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setNombre(studentDTO.getNombre());
        student.setApellido(studentDTO.getApellido());
        student.setEmail(studentDTO.getEmail());
        student.setEdad(studentDTO.getEdad());
        student.setCarrera(studentDTO.getCarrera());
        return student;
    }
} 