package com.example.inventory.controller;

import com.example.inventory.model.Product;
import com.example.inventory.service.ProductService;
import com.example.inventory.specifications.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> getProductBySpecification(ProductSpecification specification, @PageableDefault(page = 0, value = Integer.MAX_VALUE,size=10) Pageable pageable) {
        Page<Product> allProductsWithSpecification = productService.getAllProductsWithSpecification(specification, pageable);
        return new ResponseEntity<Page<Product>>(allProductsWithSpecification, HttpStatus.OK);
    }

}
