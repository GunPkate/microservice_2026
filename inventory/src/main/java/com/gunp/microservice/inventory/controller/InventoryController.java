package com.gunp.microservice.inventory.controller;

import com.gunp.microservice.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public boolean inStock(@RequestParam String skuCode, @RequestParam Integer quantity){
        return inventoryService.inStock(skuCode, quantity);
    }
}
