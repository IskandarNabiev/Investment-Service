package com.gpb.javacourse.investmentservice.controller;

import com.gpb.javacourse.investmentservice.dto.AccountInfo;
import com.gpb.javacourse.investmentservice.dto.PortfolioRecord;
import com.gpb.javacourse.investmentservice.services.BuyShares;
import com.gpb.javacourse.investmentservice.services.InvestingInfoPrinting;
import com.gpb.javacourse.investmentservice.services.RequestAccountInfo;
import com.gpb.javacourse.investmentservice.services.SellShares;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shares")
@RequiredArgsConstructor
public class Controller {

    private final BuyShares buyShares;
    private final SellShares sellShares;

    private final InvestingInfoPrinting investingInfoPrinting;
    private final RequestAccountInfo requestAccountInfo;

    @GetMapping("/buy")
    public void buyShare(){
        buyShares.buyShare(1, 1L, 34);
    }

    @GetMapping("/portfolio_info/{client_id}")
    public List<PortfolioRecord> getPortfolioInfo(@PathVariable Long client_id){
        return investingInfoPrinting.getPortfolio(client_id);
    }

    @GetMapping("/account_info/{client_id}")
    public AccountInfo getAccountInfo(@PathVariable("client_id") Long clientId) {
        return requestAccountInfo.getAccount(clientId);
    }


    @GetMapping("/sell")
    public void sellShare(){
        sellShares.sellShare(1, 1L, 34, 50.5);
    }

}
