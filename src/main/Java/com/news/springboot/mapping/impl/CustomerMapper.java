package com.news.springboot.mapping.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.springboot.entity.Customer;
import com.news.springboot.mapping.MapMapper;
import com.news.springboot.mapping.MapperJson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomerMapper implements MapperJson<Customer>, MapMapper {
    
    private final ObjectMapper objectMapper;
    
    @Override
    public Customer fromJson(String json) throws IOException {
        try {
            return objectMapper.readValue(json, Customer.class);
        } catch (IOException e) {
            throw new IOException("Failed to parse JSON to Customer", e);
        }
    }

    @Override
    public String toJson(Customer entity) throws JsonProcessingException {
        try {
            return objectMapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new JsonProcessingException("Failed to serialize Customer to JSON") {};
        }
    }
}