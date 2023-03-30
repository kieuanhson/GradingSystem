package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.DTO.AccountDTO;
import org.group9.gradingsystemserver.DTO.AccountLoginDTO;
import org.group9.gradingsystemserver.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    Optional<Account> findAccountByUsername(@Param(value = "username") String username);
}
