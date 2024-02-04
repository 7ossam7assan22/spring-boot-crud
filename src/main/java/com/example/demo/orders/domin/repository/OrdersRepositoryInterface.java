package com.example.demo.orders.domin.repository;

import com.example.demo.orders.domin.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface OrdersRepositoryInterface extends JpaRepository<Order, Serializable> {
}
