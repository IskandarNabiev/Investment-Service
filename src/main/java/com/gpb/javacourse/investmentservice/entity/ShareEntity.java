package com.gpb.javacourse.investmentservice.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Table(name = "share")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ShareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "share_id", nullable = false)
    private Integer id;

    @Column(name = "company_name", nullable = false, length = 40)
    private String companyName;

    @Column(name = "short_name", nullable = false, length = 20)
    private String shortName;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "price", nullable = false, precision = 131089)
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ShareEntity that = (ShareEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}