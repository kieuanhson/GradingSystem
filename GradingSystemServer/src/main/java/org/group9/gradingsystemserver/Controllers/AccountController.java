package org.group9.gradingsystemserver.Controllers;

import org.group9.gradingsystemserver.DAO.AccountManagement;
import org.group9.gradingsystemserver.DTO.AccountAddDTO;
import org.group9.gradingsystemserver.DTO.AccountDTO;
import org.group9.gradingsystemserver.DTO.AccountLoginDTO;
import org.group9.gradingsystemserver.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<AccountDTO> getAccount(@PathVariable String username) {
        AccountDTO account = _accountManagement.getAccountByUsername(username);
        return (account == null ? ResponseEntity.notFound().build() : new ResponseEntity<>(account, HttpStatus.OK));

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Account> addAccount(@Valid @RequestBody AccountAddDTO account) {
        if (_accountManagement.addAccount(account)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> loginToSystem(@RequestBody AccountLoginDTO accountDTO) {
        JSONObject object = new JSONObject();
        AccountDTO account = _accountManagement.getAccountByUsername(accountDTO.getUsername());
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (!account.getPassword().equals(accountDTO.getPassword())) {
            return ResponseEntity.status(406).build();
        }
        object.put("role",)
        return ResponseEntity.ok().build();
    }
}
