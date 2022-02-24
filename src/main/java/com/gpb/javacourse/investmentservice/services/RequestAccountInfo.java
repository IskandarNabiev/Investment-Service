package com.gpb.javacourse.investmentservice.services;

import com.gpb.javacourse.investmentservice.dto.AccountInfo;
import com.gpb.javacourse.investmentservice.repo.AccountInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class RequestAccountInfo {

    private final AccountInfoRepository accountInfoRepository;

    public RequestAccountInfo(AccountInfoRepository accountInfoRepository) {
        this.accountInfoRepository = accountInfoRepository;
    }

    public AccountInfo getAccount(Long clientId) {
        return accountInfoRepository.findById(clientId);
    }
}
