package com.example.domrf_test.repositpry;

import com.example.domrf_test.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SpringData CRUD репозиторий для сущности Order
 *
 * @author Корнеев Аркадий
 */

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
}
