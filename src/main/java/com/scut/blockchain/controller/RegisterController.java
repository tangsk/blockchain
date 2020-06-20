package com.scut.blockchain.controller;

import com.scut.blockchain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    AccountService accountService;

    @Autowired
    private RegisterController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/bank")
    public void registerBank(@RequestParam("account") String account, @RequestParam("password") String password, @RequestParam("name") String name) throws Exception {
        accountService.registerBank(account, password, name);
    }

    @PostMapping("/company")
    public void registerCompany(@RequestParam("account") String account, @RequestParam("password") String password, @RequestParam("name") String name) throws Exception {
        accountService.registerCompany(account, password, name);
    }

    @PostMapping("/user")
    public void registerUser(@RequestParam("account") String account, @RequestParam("password") String password, @RequestParam("name") String name) throws Exception {
        accountService.registerUser(account, password, name);
    }

}
