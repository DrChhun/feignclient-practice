package com.example.service;

import com.example.model.Order;
import com.example.model.request.OrderRequest;
import com.example.model.response.orderRes.OrderCreateResDTO;

import java.util.List;

public interface OrderService {
    OrderCreateResDTO createOrder(OrderRequest orderRequest);

    List<Order> getAllOrders();
}
