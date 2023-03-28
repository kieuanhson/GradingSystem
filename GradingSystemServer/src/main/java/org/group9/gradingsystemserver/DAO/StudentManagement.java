package org.group9.gradingsystemserver.DAO;

import org.group9.gradingsystemserver.Entity.Student;
import org.group9.gradingsystemserver.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentManagement {
    private final StudentRepository _studentRepository;

    @Autowired
    public StudentManagement(StudentRepository studentRepository) {
        _studentRepository = studentRepository;
    }

    public Student getStudentById(String id) {
        return _studentRepository.findStudentById(UUID.fromString(id));
    }
}
