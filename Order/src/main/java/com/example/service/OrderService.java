package com.example.service;

import com.example.model.request.OrderRequest;
import com.example.model.response.orderRes.OrderCreateResDTO;

import java.util.List;

public interface OrderService {
    OrderCreateResDTO createOrder(OrderRequest orderRequest);

    List<OrderCreateResDTO> getAllOrders();

    void deleteOrder(Long id);

    OrderCreateResDTO updateOrder(Long id,OrderRequest orderRequest);

    OrderCreateResDTO getOrderById(Long id);
}
