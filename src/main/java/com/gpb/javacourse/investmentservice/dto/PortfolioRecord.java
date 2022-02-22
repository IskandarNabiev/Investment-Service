package com.gpb.javacourse.investmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PortfolioRecord {

    private Long clientId;
    private Integer shareId;
    private Integer quantity;

}
