package com.gpb.javacourse.investmentservice.services;

import com.gpb.javacourse.investmentservice.entity.OperationHistoryEntity;
import com.gpb.javacourse.investmentservice.entity.PortfolioEntity;
import com.gpb.javacourse.investmentservice.repo.OperationHistoryRepo;
import com.gpb.javacourse.investmentservice.repo.PortfolioRepository;
import com.gpb.javacourse.investmentservice.repo.ShareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class SellShares {

    private final ShareRepository shareRepository;
    private final PortfolioRepository portfolioRepository;
    private final OperationHistoryRepo operationHistoryRepo;

    public void sellShare(Integer shareId, Long clientId, Integer quantity, Double cost){
        // Проверка количества доступных для продаж акций
        //ShareEntity shareEntity = shareRepository.getById(shareId);
        // Выставить на продажу по заданной цене
        // Обращаемся к БД, дергаем оттуда PortfolioRecord по идентификатору
        //, однозначно идентифицирующему акцию (потом добавим)
        // Затем у PortfolioRecord берем quantity и от quantity отнимаем текущее значение
        //кол-ва
        //Если разность равна нулю, то DELETE из БД эту запись
        //Иначе UPDATE столбца quantity для этой записи

        // тут не quantity,
        // а разность между предыдущим количеством акций и нынешним quantity
        portfolioRepository.save(new PortfolioEntity(clientId, shareId, quantity));

        operationHistoryRepo.save(new OperationHistoryEntity(clientId, shareId, quantity, cost, "sell", Instant.now()));
        // делаем трансфер clientId и quantity * cost через RestTemplate
        //

    }

}
