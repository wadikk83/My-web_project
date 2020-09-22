package by.wadikk.service;


import by.wadikk.repository.model.Order;
import by.wadikk.repository.model.User;

import java.util.List;

public interface OrderService extends CrudService<Order>{

	Order createOrder(User user);

	List<Order> findByUser(User user);

	Order findOrderWithDetails(Integer id);


}
