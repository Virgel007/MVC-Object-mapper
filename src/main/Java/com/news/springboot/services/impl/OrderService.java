package com.news.springboot.services.impl;

import com.news.springboot.entity.Order;
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
public class OrderService implements CRUDService<Order> {

    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Order getById(Integer id) {
        return null;
    }

    @Override
    public List<String> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toJson)
                .collect(Collectors.toList());
    }

    @Override
    public void create(Order item) {
        orderRepository.save(item);
    }

    @Override
    public void update(Integer id, Order item) {

    }

    @Override
    public void delete(Integer id) {

    }
}
