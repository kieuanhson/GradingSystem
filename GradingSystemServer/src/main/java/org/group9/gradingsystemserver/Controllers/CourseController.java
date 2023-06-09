package org.group9.gradingsystemserver.Controllers;

import org.group9.gradingsystemserver.DAO.CourseManagement;
import org.group9.gradingsystemserver.DAO.StudentManagement;
import org.group9.gradingsystemserver.DTO.CourseDTO;
import org.group9.gradingsystemserver.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/course")
public class CourseController {

    private final CourseManagement _courseManagement;
    private final StudentManagement _studentManagement;

    @Autowired
    public CourseController(CourseManagement courseManagement, StudentManagement studentManagement) {
        _courseManagement = courseManagement;
        _studentManagement = studentManagement;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getAll() {
        List<Course> courses = _courseManagement.getAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getCoursesByStudentId(@PathVariable String id) {
        if (_studentManagement.getStudentById(id) == null) return ResponseEntity.badRequest().build();
        List<CourseDTO> courses = _courseManagement.getByStudentId(id);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
