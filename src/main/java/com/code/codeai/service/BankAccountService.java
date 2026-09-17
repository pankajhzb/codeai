package com.code.codeai.service;

import com.code.codeai.entity.BankAccount;

import java.util.List;
public interface BankAccountService {
    BankAccount createAccount(BankAccount account);

    List<BankAccount> getAllAccounts();

    BankAccount getAccountById(Long id);

    BankAccount updateAccount(Long id, BankAccount account);

    void deleteAccount(Long id);
}
