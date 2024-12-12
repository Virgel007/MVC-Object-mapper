package com.news.springboot.services.impl;

import com.news.springboot.entity.Customer;
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

@Service
@RequiredArgsConstructor
public class CustomerServices implements CRUDService<Customer> {

    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Customer getById(Integer id) {
        return null;
    }

    @Override
    public List<String> getAll() {
        return null;
    }

    @Override
    public void create(Customer item) {

    }

    @Override
    public void update(Integer id, Customer item) {

    }

    @Override
    public void delete(Integer id) {

    }
}
