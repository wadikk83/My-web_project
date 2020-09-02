package by.wadikk.service;

import by.wadikk.repository.model.Article;
import by.wadikk.service.formfilter.ArticleFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService extends CrudService<Article> {

    List<Article> findAllArticles();

    Article findArticleById(Integer id);

    void saveArticle(Article article);

    void deleteArticleByID(Integer id);

    List<Article> getByFilter(ArticleFilter filter);
}
