package org.group9.gradingsystemserver.DAO;

import org.group9.gradingsystemserver.DTO.AccountDTO;
import org.group9.gradingsystemserver.Entity.Account;
import org.group9.gradingsystemserver.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountManagement {

    private final AccountRepository _accountRepository;

    @Autowired
    public AccountManagement(AccountRepository accountRepository) {
        _accountRepository = accountRepository;
    }

    public List<Account> getAll() {
        return _accountRepository.findAll();
    }

    public boolean addAccount(AccountDTO account) {
        Account acc = new Account(account.getUsername(), account.getPassword(), account.getRole(), account.isStatus());
        if (_accountRepository.findAccountByUserName(account.getUsername()) != null) return false;
        try {
            _accountRepository.save(acc);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteAccount(AccountDTO account) {
        Account acc = _accountRepository.findAccountByUserName(account.getUsername());
        if (acc == null) {
            return false;
        }
        try {
            _accountRepository.delete(acc);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Account getAccountById(String id) {
        try {
            UUID tmp = UUID.fromString(id);
            return _accountRepository.getReferenceById(tmp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
