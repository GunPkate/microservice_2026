package com.gunp.microservice.inventory.repository;

import com.gunp.microservice.inventory.entity.InventoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository <InventoryEntity, Long> {

    Boolean existsBySkuCode(String skuCode);
    Boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
