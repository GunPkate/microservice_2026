package com.gunp.microservice.product.dto;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, BigDecimal price) { }
