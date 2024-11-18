package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private String productCode;
    private Integer quantity;
    private BigDecimal unitPrice;
}
