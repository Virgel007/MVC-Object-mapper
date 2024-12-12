package com.news.springboot.mapping.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.springboot.entity.Order;
import com.news.springboot.mapping.MapMapper;
import com.news.springboot.mapping.MapperJson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OrderMapper implements MapperJson<Order>, MapMapper {
    
    private final ObjectMapper objectMapper;
    
    @Override
    public Order fromJson(String json) {
        try {
            return objectMapper.readValue(json, Order.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid json: " + json, e);
        }
    }

    @Override
    public String toJson(Order entity) {
        try {
            return objectMapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Invalid entity: " + entity, e);
        }
    }
}