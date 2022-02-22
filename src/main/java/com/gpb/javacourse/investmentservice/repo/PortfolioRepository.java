package com.gpb.javacourse.investmentservice.repo;

import com.gpb.javacourse.investmentservice.entity.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Long> {
    List<PortfolioEntity> getAllById(Long clientId);
}
