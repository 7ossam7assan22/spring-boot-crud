package com.example.demo.orders.domin.service;

import com.example.demo.orders.domin.entities.Order;
import com.example.demo.orders.http.requests.OrderRequest;

import java.util.List;
import java.util.Optional;

public interface OrdersServiceInterface {
    public List<Order> list();
    public Optional<Order> findById(Long id);
    public Order add(OrderRequest orderRequest);
    public Order edit(Long id, OrderRequest orderRequest) throws Exception;
    public Boolean delete(Long id);
}
