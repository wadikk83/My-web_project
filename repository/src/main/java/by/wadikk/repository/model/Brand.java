package by.wadikk.repository.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;


    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

}
