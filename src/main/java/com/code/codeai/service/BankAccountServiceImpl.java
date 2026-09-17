package com.code.codeai.service;

import com.code.codeai.entity.BankAccount;
import com.code.codeai.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService{
    private final BankAccountRepository repository;

    public BankAccountServiceImpl(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankAccount createAccount(BankAccount account) {
        return repository.save(account);
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return repository.findAll();
    }

    @Override
    public BankAccount getAccountById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Account not found: " + id));
    }

    @Override
    public BankAccount updateAccount(Long id, BankAccount account) {

        BankAccount existing = getAccountById(id);

        existing.setAccountNumber(account.getAccountNumber());
        existing.setCustomerName(account.getCustomerName());
        existing.setAccountType(account.getAccountType());
        existing.setBalance(account.getBalance());

        return repository.save(existing);
    }

    @Override
    public void deleteAccount(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Account not found: " + id);
        }

        repository.deleteById(id);
    }
}
