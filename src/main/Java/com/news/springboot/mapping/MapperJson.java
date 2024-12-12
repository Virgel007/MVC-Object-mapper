package com.news.springboot.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;


import java.io.IOException;
@Component
public interface MapperJson<T> {

    T fromJson(String json) throws IOException;

    String toJson(T entity) throws JsonProcessingException;
    
}