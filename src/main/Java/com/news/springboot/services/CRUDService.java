package com.news.springboot.services;

import java.util.List;

public interface CRUDService<T> {
    T getById(Integer id);

    List<String> getAll();

    void create(T item);

    void update(Integer id, T item);

    void delete(Integer id);
}
