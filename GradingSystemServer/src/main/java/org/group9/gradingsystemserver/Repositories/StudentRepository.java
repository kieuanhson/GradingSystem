package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    public Student findStudentById(UUID id);
}
