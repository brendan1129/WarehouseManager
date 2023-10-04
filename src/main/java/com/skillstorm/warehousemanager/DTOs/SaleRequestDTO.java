package com.skillstorm.warehousemanager.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
public class SaleRequestDTO {
    @Setter
    private BigDecimal itemPrice;
    @Setter
    private Long warehouseId;

    // Constructors (including default and parameterized constructors)

    // Getters and setters
}