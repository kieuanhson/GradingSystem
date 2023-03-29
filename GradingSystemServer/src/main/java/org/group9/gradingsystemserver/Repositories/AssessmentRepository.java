package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.Entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
    @Query(value = "SELECT `assessment`.`assessment_id`,\n" +
            "       `assessment`.`assessment_value`,\n" +
            "       `assessment`.`assessment_comment`\n" +
            "FROM `schooldatabase`.`assessment`\n" +
            "         INNER JOIN\n" +
            "     `schooldatabase`.`assessment_group` ON `assessment`.`assessment_group` = `assessment_group`.`assessment_group_code`\n" +
            "         INNER JOIN\n" +
            "     `schooldatabase`.`class_assessment_group`\n" +
            "     ON `assessment_group`.`assessment_group_code` = `class_assessment_group`.`assessment_group_code`\n" +
            "         INNER JOIN\n" +
            "     `schooldatabase`.`class` ON `class_assessment_group`.`class_code` = `class`.`class_code`\n" +
            "         INNER JOIN\n" +
            "     `schooldatabase`.`course` ON `class`.`course_id` = `course`.`course_id`\n" +
            "         INNER JOIN\n" +
            "     `schooldatabase`.`curriculum_course` ON `course`.`course_id` = `curriculum_course`.`course_id`\n" +
            "         INNER JOIN\n" +
            "     `schooldatabase`.`curriculum` ON `curriculum_course`.`cur_id` = `curriculum`.`cur_id`\n" +
            "         INNER JOIN\n" +
            "     `schooldatabase`.`student` ON `curriculum`.`cur_id` = `student`.`cur_id`\n" +
            "WHERE `student`.`acc_id` = :id\n" +
            "  AND `course`.`course_id` = :code;", nativeQuery = true)
    List<Assessment> findAssessmentsByStudentIdAndCourseCode(@Param("id") String id, @Param("code") String courseCode);
}
