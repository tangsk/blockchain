package com.scut.blockchain.controller;

import com.scut.blockchain.model.Bank;
import com.scut.blockchain.service.AccountService;
import com.scut.blockchain.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {

    @Autowired
    private BankService bankService;


    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/initial")
    public Bank hasBank(){
        return bankService.getBank();
    }
}
