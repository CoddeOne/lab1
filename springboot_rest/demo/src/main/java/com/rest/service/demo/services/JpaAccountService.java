package com.rest.service.demo.services;

import com.rest.service.demo.models.Account;
import com.rest.service.demo.repository.JpaAccountRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@Qualifier("jpaAccountService")
public class JpaAccountService implements IAccountService {
    private final JpaAccountRepository jpaAccountRepository ;
    public JpaAccountService(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }
    @Override
    public List<Account> getAccounts() {
        return jpaAccountRepository.findAll();
    }
    @Override
    public Account getAccountById(Integer id) {
        return jpaAccountRepository.findById(id).get();
    }
    @Override
    public void addAccount(Account account) {
        jpaAccountRepository.save(account);
    }
    @Override
    public void updateAccount(Account account) {
        Account accountById = getAccountById(account.getUser_id());
        accountById.setUsername(account.getUsername());
        accountById.setPassword(account.getPassword());
        accountById.setEmail(account.getEmail());
        jpaAccountRepository.save(account);
    }
    @Override
    public void deleteAccount(Integer id) {
        jpaAccountRepository.deleteById(id);
    }
}
