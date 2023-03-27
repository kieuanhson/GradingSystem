package org.group9.gradingsystemserver.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.group9.gradingsystemserver.Entity.Class;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, String> {
}
