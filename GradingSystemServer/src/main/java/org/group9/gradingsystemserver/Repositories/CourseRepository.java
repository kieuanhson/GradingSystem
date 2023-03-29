package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.DTO.CourseDTO;
import org.group9.gradingsystemserver.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(value = "select `course`.`course_id` as 'courseId',`course`.`course_name` as 'courseName',`course`.`course_credits` as 'courseCredits' from `schooldatabase`.`course` \n" +
            "inner join `schooldatabase`.`curriculum_course` on `course`.`course_id` = `curriculum_course`.`course_id`\n" +
            "inner join `schooldatabase`.`curriculum` on `curriculum_course`.`cur_id` = `curriculum`.`cur_id`\n" +
            "inner join `schooldatabase`.`student` on `curriculum`.`cur_id` = `student`.`cur_id`\n" +
            "where `student`.`acc_id` = :id;", nativeQuery = true)
    List<CourseDTO> getCourseDTOByStudentId(@Param(value = "id") String id);
}
