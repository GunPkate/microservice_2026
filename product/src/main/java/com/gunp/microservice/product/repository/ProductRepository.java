package com.gunp.microservice.product.repository;

import com.gunp.microservice.product.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product, String> {
}
