package com.gpb.javacourse.investmentservice.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Table(name = "portfolio")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PortfolioEntity {
    @Id
    @Column(name = "client_id", nullable = false, precision = 131089)
    private BigDecimal id;

    @Column(name = "share_id", nullable = false)
    private Integer shareId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PortfolioEntity that = (PortfolioEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}