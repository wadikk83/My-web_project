package by.wadikk.repository.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
