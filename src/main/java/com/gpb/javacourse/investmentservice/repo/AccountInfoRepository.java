package com.gpb.javacourse.investmentservice.repo;

import com.gpb.javacourse.investmentservice.dto.AccountInfo;

public interface AccountInfoRepository {

    AccountInfo findById(Long clientId);
}
