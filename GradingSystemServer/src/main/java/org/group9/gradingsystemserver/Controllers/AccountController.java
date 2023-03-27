package org.group9.gradingsystemserver.Controllers;

import org.group9.gradingsystemserver.DAO.AccountManagement;
import org.group9.gradingsystemserver.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
