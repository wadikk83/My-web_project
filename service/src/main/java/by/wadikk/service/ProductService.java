package by.wadikk.service;

import by.wadikk.repository.model.Product;
import by.wadikk.service.filter.ProductFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService extends CrudService<Product> {

    List<Product> findAllProduct();

    Product findProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProductByID(Integer id);

    List<Product> getByFilter(ProductFilter filter);

    List<Product> findFirstProduct(Integer n);

    List<String> getAllCategories();

    Page<Product> findProductByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh,
                                        List<String> categories, String search);
}
