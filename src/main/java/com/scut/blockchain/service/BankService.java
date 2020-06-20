package com.scut.blockchain.service;

import com.scut.blockchain.model.Bank;
import com.scut.blockchain.model.Company;
import com.scut.blockchain.repository.BankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    private CompanyService companyService;

    private ContractService contractService;

    private BankDao bankDao;

    @Autowired
    private BankService(CompanyService companyService, ContractService contractService, BankDao bankDao){
        this.companyService = companyService;
        this.contractService = contractService;
        this.bankDao = bankDao;
    }

    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    public void deliverPoints(Long companyId, Integer pointsAmount) throws Exception {
        contractService.deliverPoints(companyId, pointsAmount);
        companyService.addHoldingPoints(companyId, pointsAmount);
    }

    public void acceptPoints(Long companyId, Integer pointsAmount) throws Exception {
//        contractService.acceptPoints(companyId, pointsAmount);
        companyService.cutHoldingPoints(companyId, pointsAmount);
    }

//    void addBank(String privateKey, String contractAddress) {
//        Bank bank = new Bank();
//        bank.setPrivateKey(privateKey);
//        bank.setContractAddress(contractAddress);
//        bank.setDeliveredPoints(0);
//        bankDao.insert(bank);
//    }

    public Bank getBank() {
        return bankDao.selectOnlyOneBank();
    }
}
