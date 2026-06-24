package com.gunp.microservice.order.service;

import com.gunp.microservice.order.client.InventoryClient;
import com.gunp.microservice.order.entity.Order;
import com.gunp.microservice.order.model.OrderRequest;
import com.gunp.microservice.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final InventoryClient inventoryClient;
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){

        var isProducutInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isProducutInStock){
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
        }else{
            throw new RuntimeException("Product sku "+ orderRequest.skuCode() + " is not in stock");
        }

    }
}
