package by.wadikk.repository.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="user_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date orderDate;
	private String orderStatus;
	private BigDecimal orderTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
