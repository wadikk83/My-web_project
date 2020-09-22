package by.wadikk.repository.repository;

import by.wadikk.repository.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
