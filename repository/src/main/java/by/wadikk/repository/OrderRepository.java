package by.wadikk.repository;

import by.wadikk.repository.model.Order;
import by.wadikk.repository.model.User;

import java.util.List;

public interface OrderRepository {

    List<Order> findByUser (User user);
}
