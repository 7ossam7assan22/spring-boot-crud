package com.example.demo.orders.domin.service;

import com.example.demo.orders.domin.entities.Order;
import com.example.demo.orders.domin.repository.OrdersRepositoryInterface;
import com.example.demo.orders.http.requests.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService implements OrdersServiceInterface{

    @Autowired
    private OrdersRepositoryInterface ordersRepository;
    @Override
    public List<Order> list() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Order add(OrderRequest orderRequest) {
        Order order = new Order();
        order.setPrice(orderRequest.getPrice());
        order.setNotes(orderRequest.getNotes());
        return ordersRepository.save(order);
    }

    @Override
    public Order edit(Long id, OrderRequest orderRequest) throws Exception {
        Optional<Order> order = ordersRepository.findById(id);
        if (order.isEmpty()) {
          throw new Exception("Order with this id is not found");
        }

        order.get().setNotes(orderRequest.getNotes());
        order.get().setPrice(orderRequest.getPrice());

        return ordersRepository.save(order.get());
    }

    @Override
    public Boolean delete(Long id) {
        try {
            ordersRepository.deleteById(id);

            return true;
        }catch (Exception exception) {
            return false;
        }
    }

}
