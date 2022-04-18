package com.example.domrf_test.service;

import com.example.domrf_test.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IOrderService {

    /**
     * метод получения списка всех Заказов
     *
     * @return коллекция Закзов в List
     */
    List<Order> allOrders();

    /**
     * метод получения данных Заказа из БД по id
     *
     * @param id Первичный ключ сущности Заказ
     * @return сущность Заказ
     */
    Order getOrderById(Long id);

    /**
     * метод сохранения данных Заказа
     *
     * @param name имя Покупателя
     * @param phone телефон Покупателя
     * @param email электронная почта Покупателя
     * @param address адрес Покупателя
     */
    void createOrder(String name, String phone, String email, String address);
}
