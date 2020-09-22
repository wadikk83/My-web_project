package by.wadikk.service.impl;

import by.wadikk.repository.repository.OrderRepository;
import by.wadikk.repository.model.Order;
import by.wadikk.repository.model.User;
import by.wadikk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends CrudServiceJpaRepoImpl<Order> implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order createOrder(User user) {
        return null;
    }

    @Override
    public List<Order> findByUser(User user) {
        return null;
    }

    @Override
    public Order findOrderWithDetails(Integer id) {
        return null;
    }
}
