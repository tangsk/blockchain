package com.scut.blockchain.controller;

import com.scut.blockchain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private AccountService accountService;

    @Autowired
    private LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/bank")
    public void loginBank(@RequestParam("account") String account, @RequestParam("password") String password) {
        accountService.loginBank(account, password);
    }

    @PostMapping("/company")
    public void loginCompany(@RequestParam("account") String account, @RequestParam("password") String password) {
        accountService.loginCompany(account, password);
    }

    @PostMapping("/user")
    public void loginUser(@RequestParam("account") String account, @RequestParam("password") String password) {
        accountService.loginUser(account, password);
    }
}
