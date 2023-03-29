package org.group9.gradingsystemserver.DAO;

import org.group9.gradingsystemserver.Entity.Assessment;
import org.group9.gradingsystemserver.Repositories.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentManagement {
    private final AssessmentRepository _assessmentRepository;

    @Autowired
    public AssessmentManagement(AssessmentRepository assessmentRepository) {
        _assessmentRepository = assessmentRepository;
    }

    public List<Assessment> getAssessmentForStudentByCourses(String id, String courseCode) {
        return _assessmentRepository.findAssessmentsByStudentIdAndCourseCode(id, courseCode);
    }
}
