package com.rating.service;

import java.util.List;

/**
 * Created by kranthi
 */
public interface CRUDService<T> {
    List<?> findAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
