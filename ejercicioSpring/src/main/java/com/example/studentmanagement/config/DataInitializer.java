package com.example.studentmanagement.config;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Inicializador de datos para cargar estudiantes de ejemplo
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Autowired
    public DataInitializer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Agregar algunos estudiantes de ejemplo a la base de datos
        Student student1 = new Student(null, "Juan", "Pérez", "juan.perez@example.com", 22, "Informática");
        Student student2 = new Student(null, "María", "García", "maria.garcia@example.com", 21, "Matemáticas");
        Student student3 = new Student(null, "Carlos", "Rodríguez", "carlos.rodriguez@example.com", 23, "Física");
        
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        
        System.out.println("¡Datos de ejemplo inicializados!");
    }
} 