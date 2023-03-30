package org.group9.homeschooling.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.group9.homeschooling.DTO.AccountDTO;
import org.group9.homeschooling.DTO.AccountLoginDTO;
import org.group9.homeschooling.DTO.AccountLoginSessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    private final RestTemplate _restTemplate;
    private final ObjectMapper _objectMapper;

    @Autowired
    public AccountController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        _restTemplate = restTemplate;
        _objectMapper = objectMapper;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String getByUsername(@PathVariable String username, Model model) {
        AccountDTO account = _restTemplate.getForObject("/api/account/" + username, AccountDTO.class);
        model.addAttribute("account", account);
        return "account/view";
    }

    @RequestMapping(value = ("/login"), method = RequestMethod.GET)
    public String loginToSystem(Model model) {
        model.addAttribute("login", new AccountLoginDTO());
        return "account/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginToSystem(@ModelAttribute AccountLoginDTO account, Model model, HttpSession session) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AccountLoginDTO> request = new HttpEntity<>(account, headers);
        try {
            ResponseEntity<String> response = _restTemplate.postForEntity("/api/account/login", request, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                String responseBody = response.getBody();
                AccountLoginSessionDTO accSessionData = _objectMapper.readValue(responseBody, AccountLoginSessionDTO.class);
                session.setAttribute("account", accSessionData);
                return "redirect:/";
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                model.addAttribute("error", "No account with username " + account.getUsername() + " exists in the server.");
            }
            if (e.getStatusCode() == HttpStatus.NOT_ACCEPTABLE) {
                model.addAttribute("error", "Invalid password, please try again.");
            }
            model.addAttribute("login", account);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return "account/login";
    }
}
