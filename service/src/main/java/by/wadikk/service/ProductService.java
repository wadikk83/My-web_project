package by.wadikk.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService extends CrudService<Product> {
    List<Product> getByFilter(ProductFilter filter);
}
