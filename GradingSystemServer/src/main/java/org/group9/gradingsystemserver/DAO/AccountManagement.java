package org.group9.gradingsystemserver.DAO;

import org.group9.gradingsystemserver.DTO.AccountAddDTO;
import org.group9.gradingsystemserver.DTO.AccountDTO;
import org.group9.gradingsystemserver.DTO.AccountLoginDTO;
import org.group9.gradingsystemserver.Entity.Account;
import org.group9.gradingsystemserver.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountManagement {

    private final AccountRepository _accountRepository;

    @Autowired
    public AccountManagement(AccountRepository accountRepository) {
        _accountRepository = accountRepository;
    }

    public Iterable<Account> getAll() {
        return _accountRepository.findAll();
    }

    public Optional<Account> getAccountInfoByUsername(String username) {
        return _accountRepository.findAccountByUsername(username);
    }

    public boolean addAccount(@NotNull AccountAddDTO account) {
        if (!_accountRepository.findAccountByUsername(account.getUsername()).isPresent()) return false;
        Account acc = new Account(account.getUsername(), account.getPassword(), account.getRole());
        try {
            _accountRepository.save(acc);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
