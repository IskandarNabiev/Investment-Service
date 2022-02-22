package com.gpb.javacourse.investmentservice.repo;

import com.gpb.javacourse.investmentservice.entity.ShareEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<ShareEntity, Integer> {
}
