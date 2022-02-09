package com.gpb.javacourse.investmentservice.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Share {
    private String companyName;
    private String shortName;
    private BigDecimal cost;
    private String description;

}
