package org.group9.gradingsystemserver.Controllers;

import org.group9.gradingsystemserver.DAO.AssessmentManagement;
import org.group9.gradingsystemserver.Entity.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/api/assessment")
public class AssessmentController {
    private final AssessmentManagement _assessmentManagement;

    @Autowired
    public AssessmentController(AssessmentManagement assessmentManagement) {
        _assessmentManagement = assessmentManagement;
    }

    @RequestMapping(value = "/get?id={id}&course={course}", method = RequestMethod.GET)
    public ResponseEntity<List<Assessment>> getAssessmentForStudent(@PathVariable String course, @PathVariable String id) {
        return new ResponseEntity<>(_assessmentManagement.getAssessmentForStudentByCourses(id, course), HttpStatus.OK);
    }
}
