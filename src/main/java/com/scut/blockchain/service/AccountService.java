package com.scut.blockchain.service;

import com.scut.blockchain.exception.LoginException;
import com.scut.blockchain.model.BankAccount;
import com.scut.blockchain.model.CompanyAccount;
import com.scut.blockchain.model.UserAccount;
import com.scut.blockchain.repository.BankAccountDao;
import com.scut.blockchain.repository.CompanyAccountDao;
import com.scut.blockchain.repository.UserAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    UserAccountDao userAccountDao;

    CompanyAccountDao companyAccountDao;

    BankAccountDao bankAccountDao;

    UserService userService;

    CompanyService companyService;

    BankService bankService;

    @Autowired
    private AccountService(UserAccountDao userAccountDao,
                          CompanyAccountDao companyAccountDao,
                          BankAccountDao bankAccountDao,
                          UserService userService,
                          CompanyService companyService,
                          BankService bankService) {
        this.userAccountDao = userAccountDao;
        this.companyAccountDao = companyAccountDao;
        this.bankAccountDao = bankAccountDao;
        this.userService = userService;
        this.companyService = companyService;
        this.bankService = bankService;
    }

    public void registerCompany(String account, String password, String name) throws Exception {
        CompanyAccount companyAccount = new CompanyAccount(account, password, name);
        companyAccountDao.insertSelective(companyAccount);
//        companyService.addCompany(name);
    }

    public void registerUser(String account, String password, String name) throws Exception {
        UserAccount userAccount = new UserAccount(account, password, name);
        userAccountDao.insertSelective(userAccount);
//        userService.addUser(name);
    }

    public void registerBank(String account, String password, String name) {
        BankAccount bankAccount = new BankAccount(account, password, name);
        bankAccountDao.insertSelective(bankAccount);
    }

    public void loginBank(String account, String password) {
        BankAccount bankAccount = bankAccountDao.selectByPrimaryKey(account);
        if (bankAccount == null)
            throw new LoginException();
        else {
            if (password != bankAccount.getPassword()) {
                throw new LoginException();
            }
        }
    }

    public void loginCompany(String account, String password) {
        CompanyAccount companyAccount = companyAccountDao.selectByPrimaryKey(account);
        if (companyAccount == null)
            throw new LoginException();
        else {
            if (password != companyAccount.getPassword()) {
                throw new LoginException();
            }
        }
    }

    public void loginUser(String account, String password) {
        UserAccount userAccount = userAccountDao.selectByPrimaryKey(account);
        if (userAccount == null)
            throw new LoginException();
        else {
            if (password != userAccount.getPassword()) {
                throw new LoginException();
            }
        }
    }
}
