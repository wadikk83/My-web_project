package by.wadikk.repository.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private double price;
    private String picture;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Category> categories;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Brand> brands;

}
