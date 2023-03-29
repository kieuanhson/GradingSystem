package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.DTO.ClassDTO;
import org.group9.gradingsystemserver.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.group9.gradingsystemserver.Entity.Class;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, String> {
    @Query(value = "select `class`.`class_code` as 'classCode',`class`.`class_name` as 'className',`teacher`.`teacher_code` as 'teacherCode' from `schooldatabase`.`class` inner join `schooldatabase`.`course` on `class`.`course_id` = `course`.`course_id`\n" +
            "inner join `schooldatabase`.`curriculum_course` on `course`.`course_id` = `curriculum_course`.`course_id`\n" +
            "inner join `schooldatabase`.`curriculum` on `curriculum_course`.`cur_id` = `curriculum`.`cur_id`\n" +
            "inner join `schooldatabase`.`student` on `curriculum`.`cur_id` = `student`.`cur_id`\n" +
            "inner join `schooldatabase`.`teacher` on `class`.`teacher_id` = `teacher`.`acc_id`\n" +
            "where `student`.`acc_id` = :id;", nativeQuery = true)
    List<ClassDTO> findClassDTOByStudentId(@Param("id") String id);
}
