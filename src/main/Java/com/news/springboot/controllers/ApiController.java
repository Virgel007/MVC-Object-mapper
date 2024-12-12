package com.news.springboot.controllers;

import com.news.springboot.mapping.impl.CustomerMapper;
import com.news.springboot.mapping.impl.OrderMapper;
import com.news.springboot.mapping.impl.ProductMapper;
import com.news.springboot.services.impl.CustomerServices;
import com.news.springboot.services.impl.OrderService;
import com.news.springboot.services.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ApiController {

    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;

    private final CustomerServices customerServices;
    private final ProductService productService;
    private final OrderService orderService;

    @GetMapping("/products")
    public ResponseEntity<List<String>> getAllProducts() {
        try {
            List<String> products = productService.getAll();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<String>> getAllOrders() {
        try {
            List<String> orders = orderService.getAll();
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@Valid @RequestBody String product) {
        try {
            productService.create(productMapper.fromJson(product));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<Void> createOrder(@Valid @RequestBody String order) {
        try {
            orderService.create(orderMapper.fromJson(order));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") @NotNull Integer id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        try {
            productService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}