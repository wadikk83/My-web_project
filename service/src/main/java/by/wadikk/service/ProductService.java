package by.wadikk.service;

import by.wadikk.repository.model.Product;
import by.wadikk.service.formfilter.ProductFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService extends CrudService<Product> {

    List<Product> findAllProduct();

    Product findProductById(Integer id);

    void saveProduct(Product article);

    void deleteProductByID(Integer id);

    List<Product> getByFilter(ProductFilter filter);

    List<Product> findFirstProduct();
}
