package com.example.controller;

import com.example.model.request.OrderRequest;
import com.example.model.response.GetResponse;
import com.example.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    private ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        return GetResponse.responseCreate(
                "Successfully created order",
                orderService.createOrder(orderRequest)
        );
    }

    @GetMapping("all")
    private ResponseEntity<?> getAllOrders() {
        return GetResponse.responseList(
                "Successfully get all orders",
                orderService.getAllOrders(),
                orderService.getAllOrders().size()
        );
    }
}
