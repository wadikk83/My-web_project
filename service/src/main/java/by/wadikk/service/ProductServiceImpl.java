package by.wadikk.service;

import by.wadikk.repository.ProductRepository;
import by.wadikk.repository.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends CrudServiceJpaRepoImpl<Product> implements ProductService {
    @Autowired
    public ProductRepository repo;

    private static final ObjectMapper MAPPER = new ObjectMapper();


    @Override
    public List<Product> getByFilter(ProductFilter filter) {
        return repo.findAll(Example.of(MAPPER.convertValue(filter, Product.class)));
    }

}
