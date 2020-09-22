package by.wadikk.repository.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Category(String name, Product product) {
        this.name = name;
        this.product = product;
    }


}
