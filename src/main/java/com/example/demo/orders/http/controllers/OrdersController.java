package com.example.demo.orders.http.controllers;

import com.example.demo.orders.domin.entities.Order;
import com.example.demo.orders.domin.service.OrdersServiceInterface;
import com.example.demo.orders.http.requests.OrderRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersServiceInterface ordersService;

    @GetMapping
    public ResponseEntity<List<Order>> index() {
        return new ResponseEntity<>(ordersService.list(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(ordersService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> add(@Valid @RequestBody OrderRequest orderRequest) {
        Order order = ordersService.add(orderRequest);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> edit(@PathVariable(name = "id") Long id, @Valid @RequestBody OrderRequest orderRequest){

        try {
            Order order = ordersService.edit(id, orderRequest);
            return new ResponseEntity<>(order, HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable(name = "id") Long id) {
        if (ordersService.delete(id)) {
            return HttpStatus.OK;
        }

        return HttpStatus.BAD_REQUEST;
    }
}
