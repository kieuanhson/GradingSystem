package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.Entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
}
