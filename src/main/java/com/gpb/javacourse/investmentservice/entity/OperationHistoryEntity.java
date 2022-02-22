package com.gpb.javacourse.investmentservice.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Objects;

@Table(name = "operation_history")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class OperationHistoryEntity {
    @Id
    @Column(name = "client_id", nullable = false, precision = 131089)
    private Long id;

    @Column(name = "share_id", nullable = false)
    private Integer shareId;

    @Column(name = "quantity", precision = 131089)
    private Integer quantity;

    @Column(name = "current_cost", nullable = false, precision = 131089)
    private Double currentCost;

    @Column(name = "operation_type", nullable = false, length = 20)
    private String operationType;

    @Column(name = "operation_datetime", nullable = false)
    private Instant operationDatetime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OperationHistoryEntity that = (OperationHistoryEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}