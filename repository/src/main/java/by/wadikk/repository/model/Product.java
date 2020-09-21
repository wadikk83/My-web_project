package by.wadikk.repository.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private int stock;	
	private double price;
	private String picture;
	
	/*@ManyToOne
	private Set<Category> categories;*/

}
