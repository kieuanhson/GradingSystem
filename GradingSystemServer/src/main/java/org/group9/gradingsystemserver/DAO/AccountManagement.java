package org.group9.gradingsystemserver.DAO;

import org.group9.gradingsystemserver.DTO.AccountAddDTO;
import org.group9.gradingsystemserver.DTO.AccountDTO;
import org.group9.gradingsystemserver.DTO.AccountLoginDTO;
import org.group9.gradingsystemserver.Entity.Account;
import org.group9.gradingsystemserver.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

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


    public boolean addAccount(@NotNull AccountAddDTO account) {
        Account acc = new Account(account.getUsername(), account.getPassword(), account.getRole(), account.isStatus());
        if (_accountRepository.findAccountByUsername(acc.getUsername()) != null) return false;
        try {
            _accountRepository.save(acc);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public AccountDTO getAccountByUsername(String username) {
        try {
            return _accountRepository.findAccountByUsername(username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public AccountLoginDTO findLoginInfoByUserName(String username) {
        try {
            return _accountRepository.getLoginInfoByUsername(username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
