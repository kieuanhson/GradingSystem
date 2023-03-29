package org.group9.gradingsystemserver.DAO;

import org.group9.gradingsystemserver.DTO.ClassDTO;
import org.group9.gradingsystemserver.Repositories.ClassRepository;
import org.springframework.stereotype.Service;
import org.group9.gradingsystemserver.Entity.Class;

import java.util.List;

@Service
public class ClassManagement {
    private final ClassRepository _classRepository;

    public ClassManagement(ClassRepository classRepository) {
        _classRepository = classRepository;
    }

    public List<Class> getAll() {
        return _classRepository.findAll();
    }

    public List<ClassDTO> getClassesByStudentId(String id) {
        return _classRepository.findClassDTOByStudentId(id);
    }
}
