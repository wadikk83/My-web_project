package by.wadikk.repository;

import by.wadikk.repository.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
}
