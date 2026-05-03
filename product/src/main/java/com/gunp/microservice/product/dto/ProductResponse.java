package com.gunp.microservice.product.dto;

import java.math.BigDecimal;

public record ProductResponse (String id, String name, String description, BigDecimal price) { }


