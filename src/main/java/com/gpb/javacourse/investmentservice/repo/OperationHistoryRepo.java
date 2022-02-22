package com.gpb.javacourse.investmentservice.repo;

import com.gpb.javacourse.investmentservice.entity.OperationHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationHistoryRepo extends JpaRepository<OperationHistoryEntity, Long> {
}
