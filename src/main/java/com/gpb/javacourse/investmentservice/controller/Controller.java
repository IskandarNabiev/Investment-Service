package com.gpb.javacourse.investmentservice.controller;

import com.gpb.javacourse.investmentservice.services.BuyShares;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shares")
@RequiredArgsConstructor
public class Controller {


    private final BuyShares buyShares;

    @GetMapping("/buy")
    public void buyShare(){
        buyShares.buyShare(1, 1L, 34);
    }
}
