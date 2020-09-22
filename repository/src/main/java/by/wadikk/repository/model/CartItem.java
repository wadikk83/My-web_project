package by.wadikk.repository.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private int quantity;

	@OneToOne
	@JoinColumn(name="article_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

}