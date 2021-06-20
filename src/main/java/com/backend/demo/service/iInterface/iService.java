package com.backend.demo.service.iInterface;

import java.util.Optional;

public interface iService<T> {
    Iterable<T> findAll();

    T save(T t);

    Optional<T> findById(Long id);

    void remove(Long id);
}
