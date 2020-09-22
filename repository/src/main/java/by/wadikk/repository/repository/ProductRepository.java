package by.wadikk.repository.repository;


import by.wadikk.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT DISTINCT c.name FROM Category c")
    List<String> findAllCategories();
}
