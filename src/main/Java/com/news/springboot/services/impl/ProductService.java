package com.news.springboot.services.impl;

import com.news.springboot.entity.Product;
import com.news.springboot.mapping.impl.CustomerMapper;
import com.news.springboot.mapping.impl.OrderMapper;
import com.news.springboot.mapping.impl.ProductMapper;
import com.news.springboot.repositories.CustomerRepository;
import com.news.springboot.repositories.OrderRepository;
import com.news.springboot.repositories.ProductRepository;
import com.news.springboot.services.CRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements CRUDService<Product> {

    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public List<String> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toJson)
                .collect(Collectors.toList());
    }

    @Override
    public void create(Product item) {
        productRepository.save(item);
    }

    @Override
    public void update(Integer id, Product item) {

    }

    @Override
    public void delete(Integer id) {
        Long idLong = Long.valueOf(id);
        productRepository.deleteById(idLong);
    }
}
