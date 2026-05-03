package com.gunp.microservice.product.service;

import com.gunp.microservice.product.dto.ProductRequest;
import com.gunp.microservice.product.dto.ProductResponse;
import com.gunp.microservice.product.model.Product;
import com.gunp.microservice.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .description(productRequest.description())
                .build();
        productRepository.save(product);
        log.info("Product created succesfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts(){
        Stream<Product> stream =  StreamSupport.stream(productRepository.findAll().spliterator(),false);
        return stream.map(
                product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice() )
        ).toList();
    }
}
