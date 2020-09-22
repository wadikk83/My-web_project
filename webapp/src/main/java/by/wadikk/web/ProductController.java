package by.wadikk.web;

import by.wadikk.repository.model.Category;
import by.wadikk.repository.model.Product;
import by.wadikk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/add")
    public String addArticle(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
        Product newProduct = new Product();
        newProduct.setTitle(product.getTitle());
        newProduct.setStock(product.getStock());
        newProduct.setPrice(product.getPrice());
        newProduct.setPicture(product.getPicture());
        newProduct.setCategories(product.getCategories());
        productService.saveProduct(newProduct);
        return "redirect:/product-list";
    }

    @RequestMapping("/product-list")
    public String ProductList(Model model) {
        List<Product> products = productService.findAllProduct();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/edit")
    public String editProduct(@RequestParam("id") Integer id, Model model) {
        Product product = productService.findProductById(id);

        String preselectedCategories = "";
        for (Category category : product.getCategories()) {
            preselectedCategories += (category.getName() + ",");
        }
        model.addAttribute("product", product);
        model.addAttribute("preselectedCategories", preselectedCategories);
        model.addAttribute("allCategories", productService.getAllCategories());
        return "editProduct";
    }

    @PostMapping("/edit")
    public String editArticlePost(@ModelAttribute("product") Product product) {

        Product productToUpdate = productService.getById(product.getId());
        productToUpdate.setTitle(product.getTitle());
        productToUpdate.setStock(product.getStock());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setPicture(product.getPicture());


        if (product.getCategories() != null && !product.getCategories().isEmpty()) {
            Set<Category> categoryElements = new HashSet<>();
            for (Category value : product.getCategories()) {
                categoryElements.add(new Category(value.getName(), product));
            }
            productToUpdate.setCategories(categoryElements);
        }

        productService.save(productToUpdate);

        return "redirect:/product/product-list";
    }

    @RequestMapping("/delete")
    public String deleteArticle(@RequestParam("id") Integer id) {
        productService.deleteProductByID(id);
        return "redirect:/product-list";
    }

}
