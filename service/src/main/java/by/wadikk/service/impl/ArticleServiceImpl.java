package by.wadikk.service.impl;

import by.wadikk.repository.ArticleRepository;
import by.wadikk.repository.model.Article;
import by.wadikk.service.formfilter.ArticleFilter;
import by.wadikk.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl extends CrudServiceJpaRepoImpl<Article> implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article findArticleById(Integer id) {
        return null;
    }

    @Override
    public void saveArticle(Article article) {

    }

    @Override
    public void deleteArticleByID(Integer id) {

    }

    @Override
    public List<Article> getByFilter(ArticleFilter filter) {
        return null;
    }
}
