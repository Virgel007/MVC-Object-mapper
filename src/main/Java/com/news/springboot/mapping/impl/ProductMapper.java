package com.news.springboot.mapping.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.springboot.entity.Product;
import com.news.springboot.mapping.MapMapper;
import com.news.springboot.mapping.MapperJson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ProductMapper implements MapperJson<Product>, MapMapper {

    private final ObjectMapper objectMapper;

    @Override
    public Product fromJson(String json) {
        try {
            return objectMapper.readValue(json, Product.class);
        } catch (IOException e) {
            throw new RuntimeException("Error while parsing JSON", e);
        }
    }

    @Override
    public String toJson(Product entity) {
        try {
            return objectMapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error while serializing to JSON", e);
        }
    }
}