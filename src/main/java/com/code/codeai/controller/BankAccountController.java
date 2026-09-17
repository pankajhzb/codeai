package com.code.codeai.controller;

import com.code.codeai.entity.BankAccount;
import com.code.codeai.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {
    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankAccount createAccount(
            @Valid @RequestBody BankAccount account) {

        return service.createAccount(account);
    }

    @GetMapping
    public List<BankAccount> getAllAccounts() {

        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getAccountById(
            @PathVariable Long id) {

        return service.getAccountById(id);
    }

    @PutMapping("/{id}")
    public BankAccount updateAccount(
            @PathVariable Long id,
            @Valid @RequestBody BankAccount account) {

        return service.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(
            @PathVariable Long id) {

        service.deleteAccount(id);
    }
}
