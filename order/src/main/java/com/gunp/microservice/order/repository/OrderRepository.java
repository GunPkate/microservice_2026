package com.gunp.microservice.order.repository;

import com.gunp.microservice.order.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
