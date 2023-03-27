package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
