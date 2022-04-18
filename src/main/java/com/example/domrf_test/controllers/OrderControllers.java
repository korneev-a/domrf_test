package com.example.domrf_test.controllers;

import com.example.domrf_test.model.Order;
import com.example.domrf_test.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллеры для CRUD операций над заказами
 */

@RestController
@RequestMapping("/order")
public class OrderControllers {

    IOrderService orderService;

    @Autowired
    public OrderControllers(IOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Контроллер на запрос данных покупателей списка всех Заказов
     * @return http ответ на исход запроса
     */
    @GetMapping("/allOrders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orderList = orderService.allOrders();
        if (!orderList.isEmpty()) {
            return ResponseEntity.ok(orderList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Контроллер на получение данных покупателя по номеру id Заказа
     * @param id - Первичный ключ сущности Заказ
     * @return http ответ на исход запроса
     */
    @GetMapping("/allOrders/{id}")
    public ResponseEntity<Order> getOrderByID(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null){
            return ResponseEntity.ok(order);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Контроллер для сохранения новых данных о покупателе при Заказе
     * @param name имя Покупателя
     * @param phone телефон Покупателя
     * @param email электронная почта Покупателя
     * @param address адрес Покупателя
     */
    @PostMapping("/")
    public void createNewOrder (@RequestParam String name,
                                @RequestParam String phone,
                                @RequestParam String email,
                                @RequestParam String address) {
        orderService.createOrder(name, phone, email, address);
    }
}
