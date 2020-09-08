package by.wadikk.web;

import by.wadikk.repository.model.Article;
import by.wadikk.service.formfilter.ArticleFilter;
import by.wadikk.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/products")
public class ProductManagementController {

 /*  // @Autowired
    //private ArticleService articleService;

    @GetMapping(path = "/{id}")
    public Article getById(@PathVariable Integer id) {
        return articleService.getById(id);
    }

    @PostMapping
    public Article save(@RequestBody Article product) {
        return articleService.save(product);
    }

    @PostMapping(path = "/query}")
    public List<Article> getByFilter(@RequestBody ArticleFilter articleFilter) {
        return articleService.getByFilter(articleFilter);
    }*/
}
