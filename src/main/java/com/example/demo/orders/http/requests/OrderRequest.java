package com.example.demo.orders.http.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class OrderRequest {

    private Double price;

    private String notes;
}