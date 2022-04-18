package com.example.domrf_test.service;

import com.example.domrf_test.exception.OrderNotFoundException;
import com.example.domrf_test.model.Order;
import com.example.domrf_test.repositpry.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    IOrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> allOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                ()-> new OrderNotFoundException("Заказ по номеру " + id +" не найден."));
    }

    @Override
    public void createOrder(String name, String phone, String email, String address) {
        Order order = new Order(name, phone, email, address);
        orderRepository.save(order);
    }
}
