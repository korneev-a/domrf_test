package com.example.domrf_test.model;


import javax.persistence.*;

/**
 * Сущность Заказ и сопоставление с БД
 * @author Корнеев Аркадий
 */

@Entity
@Table(name = "orders")
public class Order {

    /** Поле id - Первичный ключ */
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /** Поле Имя_Покупателя */
    @Column(name = "customer_name")
    String name;

    /** Поле Номер_Телефона_Покупателя */
    @Column(name = "customer_phone")
    String phone_number;

    /** Поле Электронная_Почта_Покупателя */
    @Column(name = "customer_email")
    String email;

    /** Поле Адрес_Покупателя */
    @Column(name = "customer_address")
    String address;

    public Order() {
    }

    public Order(String name, String phone_number, String email, String address) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
