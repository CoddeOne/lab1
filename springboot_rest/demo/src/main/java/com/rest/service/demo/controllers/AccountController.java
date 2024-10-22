package com.rest.service.demo.controllers;

import com.rest.service.demo.models.Account;
import com.rest.service.demo.services.IAccountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/accounts")
public class AccountController {
    private final IAccountService accountService;
    public AccountController(@Qualifier ("jpaAccountService") IAccountService accountService) {
         this.accountService = accountService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }
    @PostMapping
    public ResponseEntity<String> addAccount(@RequestBody Account account)  {
        accountService.addAccount(account);
        return ResponseEntity.ok( "inserted");
    }
    @PutMapping
    public ResponseEntity<String> updateAccount(@RequestBody  Account account) {
        accountService.updateAccount(account);
        return ResponseEntity.ok("updated");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Integer id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("deleted");
    }

}
