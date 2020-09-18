package by.wadikk.service;

import by.wadikk.repository.model.Article;

import java.util.List;

public interface CrudService<T> {

    T getById(Integer id);

    List<T> getAll();

    void save(T t);

    void delete(T t);

}
