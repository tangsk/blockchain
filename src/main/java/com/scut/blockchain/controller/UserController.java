package com.scut.blockchain.controller;

import com.scut.blockchain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/getPoints")
    public void getPoints(@PathVariable("userId") Long userId, @RequestParam("companyId") Long companyId,
                          @RequestParam("pointsAmount") Integer pointsAmount) throws Exception {
        userService.getPoints(userId, companyId, pointsAmount);
    }

    @PostMapping("/{userId}/giveAwayPoints")
    public void giveAwayPoints(@PathVariable("userId") Long userId, @RequestParam("toUserId") Long toUserId,
                                   @RequestParam("pointsAmount") Integer pointsAmount) throws Exception {
        userService.giveAwayPoints(userId, toUserId, pointsAmount);
    }

    @GetMapping("/companyInfo")
    public Object getAllCompanyInfo() {
        return userService.getAllCompanyInfo();
    }

    @PostMapping("{userId}/usePoints")
    public void usePoints(@PathVariable("userId") Long userId, @RequestParam("companyId") Long companyId,
                          @RequestParam("pointsAmount") Integer pointsAmount) throws Exception {
        userService.usePoints(userId, companyId, pointsAmount);
    }
}
