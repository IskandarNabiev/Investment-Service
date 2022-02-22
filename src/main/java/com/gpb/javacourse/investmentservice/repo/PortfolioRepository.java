package com.gpb.javacourse.investmentservice.repo;

import com.gpb.javacourse.investmentservice.entity.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Long> {
}
