package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    public Account findAccountByUserName(String username);
}
