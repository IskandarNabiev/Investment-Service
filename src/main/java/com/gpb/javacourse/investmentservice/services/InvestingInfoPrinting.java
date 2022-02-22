package com.gpb.javacourse.investmentservice.services;

import com.gpb.javacourse.investmentservice.dto.PortfolioRecord;
import com.gpb.javacourse.investmentservice.entity.PortfolioEntity;
import com.gpb.javacourse.investmentservice.repo.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvestingInfoPrinting {

    private final PortfolioRepository portfolioRepository;

    public List<PortfolioRecord> getPortfolio(Long clientId) {
        List<PortfolioEntity> portfolioEntity = portfolioRepository.getAllById(clientId);
        List<PortfolioRecord> portfolioRecordsList = new ArrayList<>();
        for(PortfolioEntity p : portfolioEntity){
            portfolioRecordsList.add(portfolioEntityToPortfolioRecord(p));
        }
        return portfolioRecordsList;
    }

    private PortfolioRecord portfolioEntityToPortfolioRecord(PortfolioEntity portfolioEntity) {
        return new PortfolioRecord(portfolioEntity.getId(), portfolioEntity.getQuantity(), portfolioEntity.getShareId());
    }
}
