package by.wadikk.service.impl;

import by.wadikk.repository.repository.ProductRepository;
import by.wadikk.repository.model.Product;
import by.wadikk.service.ProductService;
import by.wadikk.service.filter.ProductFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl extends CrudServiceJpaRepoImpl<Product> implements ProductService {

    @Autowired
    ProductRepository productRepository;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public List<Product> findAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductByID(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getByFilter(ProductFilter filter) {
        return productRepository.findAll(Example.of(MAPPER.convertValue(filter, Product.class)));
    }

    @Override
    public List<Product> findFirstProduct(Integer featuredProductNumber) {
        return productRepository.findAll(PageRequest.of(0, featuredProductNumber)).getContent();
    }

    @Override
    public List<String> getAllCategories() {
        return productRepository.findAllCategories();
    }

    @Override
    public Page<Product> findProductByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh, List<String> categories, String search) {
        //Page<Product> page = productRepository.findAll();
        return null;
    }
}
