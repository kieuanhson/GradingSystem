package org.group9.gradingsystemserver.DAO;

import org.group9.gradingsystemserver.Entity.Course;
import org.group9.gradingsystemserver.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManagement {
    private final CourseRepository _courseRepository;

    @Autowired
    public CourseManagement(CourseRepository courseRepository) {
        _courseRepository = courseRepository;
    }

    public List<Course> getAll() {
        return _courseRepository.findAll();
    }

    public List<Course> getByStudentId(String id) {
        return _courseRepository.getAllByStudentId(id);
    }
}
