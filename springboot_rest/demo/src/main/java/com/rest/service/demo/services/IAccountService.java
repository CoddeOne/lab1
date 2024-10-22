package com.rest.service.demo.services;



import com.rest.service.demo.models.Account;

import java.util.List;

public interface IAccountService {

    List<Account> getAccounts();
    Account getAccountById(Integer id);
    void addAccount(Account account);
    void updateAccount( Account account);
     void deleteAccount( Integer id) ;

}
