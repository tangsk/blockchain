package com.scut.blockchain.controller;

import com.scut.blockchain.service.GiftService;
import com.scut.blockchain.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private GiftService giftService;

    private GoodsService goodsService;

    @Autowired
    public CompanyController(GiftService giftService, GoodsService goodsService) {
        this.giftService = giftService;
        this.goodsService = goodsService;
    }

    @DeleteMapping("/{companyId}/delGift")
    public void delGift(@PathVariable("companyId") Long companyId, Long giftId) {
        giftService.delGift(companyId, giftId);
    }

    @GetMapping("/{companyId}/getAllGifts")
    public Object getAllGifts(@PathVariable("companyId") Long companyId) {
        return giftService.getAllGifts(companyId);
    }

    @GetMapping("/{companyId}/posGift")
    public void posGift(@PathVariable("companyId") Long companyId, String name, Integer pointsPrice) {
        giftService.posGift(companyId, name, pointsPrice);
    }

    @DeleteMapping("/{companyId}/delGoods")
    public void delGoods(@PathVariable("companyId") Long companyId, Long goodsId) {
        goodsService.delGoods(companyId, goodsId);
    }

    @GetMapping("/{companyId}/getAllGoods")
    public Object getAllGoods(@PathVariable("companyId") Long companyId) {
        return goodsService.getAllGoods(companyId);
    }

    @PostMapping("/{companyId}/posGoods")
    public Object posGoods(@PathVariable("companyId") Long companyId, String name, Integer pointsPrice) {
        return goodsService.posGoods(companyId, name, pointsPrice);
    }

}
