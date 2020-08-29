package by.wadikk.web;

import by.wadikk.service.ProductFilter;
import by.wadikk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/products")
public class ProductManagementController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/{id}")
    public Product getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);


    }

    @PostMapping(path = "/query}")
    public List<Product> getByFilter(@RequestBody ProductFilter productFilter) {
        return productService.getByFilter(productFilter);
    }
}
