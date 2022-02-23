package com.gpb.javacourse.investmentservice.services;

import com.gpb.javacourse.investmentservice.entity.OperationHistoryEntity;
import com.gpb.javacourse.investmentservice.entity.PortfolioEntity;
import com.gpb.javacourse.investmentservice.entity.ShareEntity;
import com.gpb.javacourse.investmentservice.repo.OperationHistoryRepo;
import com.gpb.javacourse.investmentservice.repo.PortfolioRepository;
import com.gpb.javacourse.investmentservice.repo.ShareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class BuyShares {

    private final ShareRepository shareRepository;
    private final PortfolioRepository portfolioRepository;
    private final OperationHistoryRepo operationHistoryRepo;

    public void buyShare(Integer shareId, Long clientId, Integer quantity){
        //запрос к мосбирже и апдейтим таблицу share
        ShareEntity shareEntity = shareRepository.getById(shareId);
        double cost = shareEntity.getPrice();
        //проверка на баланс
        portfolioRepository.save(new PortfolioEntity(clientId, shareId, quantity));
        operationHistoryRepo.save(new OperationHistoryEntity(clientId, shareId, quantity, cost, "buy", Instant.now()));
        // обращаемся к сервису трансфера и делаем трансфер передавая clientId и quantity * cost

    }
}
