package org.group9.gradingsystemserver.Controllers;

import org.group9.gradingsystemserver.DAO.AccountManagement;
import org.group9.gradingsystemserver.DTO.AccountDTO;
import org.group9.gradingsystemserver.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {
    private final AccountManagement _accountManagement;

    @Autowired
    public AccountController(AccountManagement accountManagement) {
        _accountManagement = accountManagement;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = _accountManagement.getAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable String id) {
        Account acc = _accountManagement.getAccountById(id);
        return (acc != null ? new ResponseEntity<>(acc, HttpStatus.OK) : ResponseEntity.badRequest().build());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Account> addAccount(@Valid @RequestBody AccountDTO account) {
        if (_accountManagement.addAccount(account)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }
}
