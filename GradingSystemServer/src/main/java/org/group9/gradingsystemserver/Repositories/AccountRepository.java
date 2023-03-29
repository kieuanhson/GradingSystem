package org.group9.gradingsystemserver.Repositories;

import org.group9.gradingsystemserver.DTO.AccountDTO;
import org.group9.gradingsystemserver.DTO.AccountLoginDTO;
import org.group9.gradingsystemserver.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    @Query(value = "select new org.group9.gradingsystemserver.DTO.AccountDTO(a.username,a.role,a.status) from Account a\n" +
            "where a.username = :username")
    AccountDTO findAccountByUsername(@Param(value = "username") String username);

    @Query(value = "select new org.group9.gradingsystemserver.DTO.AccountLoginDTO(a.username,a.password,a.role) from Account a where a.username = :username")
    AccountLoginDTO getLoginInfoByUsername(@Param(value = "username") String username);
}
