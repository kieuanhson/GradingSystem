package org.group9.gradingsystemserver.Controllers;

import org.group9.gradingsystemserver.DAO.AccountManagement;
import org.group9.gradingsystemserver.DTO.AccountAddDTO;
import org.group9.gradingsystemserver.DTO.AccountDTO;
import org.group9.gradingsystemserver.DTO.AccountLoginDTO;
import org.group9.gradingsystemserver.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {
    private final AccountManagement _accountManagement;

    @Autowired
    public AccountController(AccountManagement accountManagement) {
        _accountManagement = accountManagement;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Account> addAccount(@Valid @RequestBody AccountAddDTO account) {
        if (_accountManagement.addAccount(account)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAll() {
        return new ResponseEntity<>(_accountManagement.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> loginToSystem(@RequestBody AccountLoginDTO accountDTO) {
        Optional<Account> account = _accountManagement.getAccountInfoByUsername(accountDTO.getUsername());
        if (!account.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if (!account.get().getPassword().equals(accountDTO.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Map<String, String> body = new HashMap<>();
        body.put("id", account.get().getId().toString());
        body.put("role", account.get().getRole().toString());
        body.put("displayName", account.get().getAccountDetail().getFullName());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
