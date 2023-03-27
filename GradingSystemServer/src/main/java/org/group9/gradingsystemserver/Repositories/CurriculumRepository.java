package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.Entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, String> {
}
