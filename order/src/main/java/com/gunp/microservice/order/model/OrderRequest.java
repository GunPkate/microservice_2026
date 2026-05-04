package com.gunp.microservice.order.model;

import java.math.BigDecimal;

public record OrderRequest(long id, String orderNUmber, String skuCode, BigDecimal price,Integer quantity) {
}
