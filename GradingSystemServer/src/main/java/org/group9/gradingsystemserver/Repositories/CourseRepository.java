package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(value = "select `course`.course_id,`course`.course_name,`course`.course_credits from `schooldatabase`.`course` inner join `schooldatabase`.curriculum_course\n" +
            "on `course`.course_id = `curriculum_course`.course_id\n" +
            "inner join `schooldatabase`.`curriculum`\n" +
            "on `curriculum_course`.cur_id = `curriculum`.cur_id\n" +
            "inner join `schooldatabase`.`student`\n" +
            "on `curriculum`.cur_id = `student`.cur_id\n" +
            "where `student`.acc_id = :id;", nativeQuery = true
    )
    List<Course> getAllByStudentId(@Param(value = "id") String id);
}
