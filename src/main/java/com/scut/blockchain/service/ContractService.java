package com.scut.blockchain.service;

import com.scut.blockchain.constants.GasConstants;
import com.scut.blockchain.contracts.Points;
import com.scut.blockchain.exception.BlockChainException;
import com.scut.blockchain.model.Bank;
import com.scut.blockchain.model.Company;
import com.scut.blockchain.model.User;

import com.scut.blockchain.repository.BankDao;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.EncryptType;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ContractService {

    private Web3j web3j;

    private Credentials bankCredentials;

    private Points points;
//
//    private UserService userService;
//
//    @Autowired
    private CompanyService companyService;

    private BankDao bankDao;

    @Autowired
    public ContractService(Web3j web3j, CompanyService companyService, BankDao bankDao) throws Exception {
        this.web3j = web3j;
        this.companyService = companyService;
        this.bankDao = bankDao;
        Bank bank = bankDao.selectOnlyOneBank();
        if (bank == null) {
            deploy();
        } else {
            this.bankCredentials = Credentials.create(bank.getPrivateKey());
            this.points = Points.load(bank.getContractAddress(), web3j, bankCredentials,new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        }
    }

    private boolean deploy() {
        try {
            EncryptType.encryptType = 0;
            this.bankCredentials = GenCredential.create();
            this.points = Points.deploy(web3j, bankCredentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT)).send();
            Bank bank = new Bank();
            bank.setContractAddress( points.getContractAddress());
            bank.setDeliveredPoints(0);
            bank.setPrivateKey(bankCredentials.getAddress());
            bankDao.insertSelective(bank);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void deliverPoints(Long companyId, Integer pointsAmount) throws Exception {
        Company company = companyService.getCompany(companyId);
        TransactionReceipt receipt = points.deliverPoints(BigInteger.valueOf(company.getId()), new BigInteger(pointsAmount.toString())).send();

        //日志
        List<Points.DeliverPointsEventResponse> response = points.getDeliverPointsEvents(receipt);
        if (response.isEmpty())
            throw new BlockChainException();
    }

//    public void getPoints(Long userId, Long companyId, Integer pointsAmount) throws Exception {
//
//        User user = userService.getUser(userId);
//        Credentials userCredentials = GenCredential.create(user.getPrivateKey());
//        Company company = companyService.getCompany(companyId);
//        Points points = loadContract(userCredentials);
//
//        TransactionReceipt receipt = points.getPoints(BigInteger.valueOf(user.getId()), BigInteger.valueOf(company.getId()), new BigInteger(pointsAmount.toString())).send();
//
//        List<Points.GetPointsEventResponse> response = points.getGetPointsEvents(receipt);
//        if (response.isEmpty())
//            throw new BlockChainException();
//    }
//
//
//    public void usePoints(Long userId, Long companyId, Integer pointsAmount) throws Exception {
//
//        User user = userService.getUser(userId);
//        Credentials userCredentials = GenCredential.create(user.getPrivateKey());
//        Company company = companyService.getCompany(companyId);
//        Points points = loadContract(userCredentials);
//
//        TransactionReceipt receipt = points.getPoints(BigInteger.valueOf(user.getId()), BigInteger.valueOf(company.getId()), new BigInteger(pointsAmount.toString())).send();
//
//        List<Points.UsePointsEventResponse> response = points.getUsePointsEvents(receipt);
//        if (response.isEmpty())
//            throw new BlockChainException();
//    }
//
//
//    public void giveAwayPoints(Long userId, Long toUserId, Integer pointsAmount) throws Exception {
//
//        User user = userService.getUser(userId);
//        Credentials userCredentials = GenCredential.create(user.getPrivateKey());
//        User toUser= userService.getUser(toUserId);
//        Points points = loadContract(userCredentials);
//
//        TransactionReceipt receipt = points.giveAwayPoints(BigInteger.valueOf(user.getId()), BigInteger.valueOf(toUser.getId()), new BigInteger(pointsAmount.toString())).send();
//
//
//        List<Points.GiveAwayPointsEventResponse> response = points.getGiveAwayPointsEvents(receipt);
//        if (response.isEmpty())
//            throw new BlockChainException();
//    }
//
//

//
//
//    public void acceptPoints(Long companyId, Integer pointsAmount) throws Exception {
//        Company company = companyService.getCompany(companyId);
//        Credentials companyCredentials = GenCredential.create(company.getPrivateKey());
//        Points points = loadContract(companyCredentials);
//        TransactionReceipt receipt = points.acceptPoints(BigInteger.valueOf(company.getId()), new BigInteger(pointsAmount.toString())).send();
//
//
//        List<Points.AcceptPointsEventResponse> response = points.getAcceptPointsEvents(receipt);
//        if (response.isEmpty())
//            throw new BlockChainException();
//    }
}
