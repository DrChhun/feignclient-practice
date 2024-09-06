package com.example.controller;

import com.example.Order;
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
    private final Order order;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        return GetResponse.responseCreate(
                "Successfully created order",
                orderService.createOrder(orderRequest)
        );
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllOrders() {
        return GetResponse.responseList(
                "Successfully get all orders",
                orderService.getAllOrders(),
                orderService.getAllOrders().size()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        return GetResponse.responseObject(
                "Successfully get order by id ",
                id.intValue(),
                orderService.getOrderById(id)
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return GetResponse.responseDelete(
                "Successfully delete order id ",
                id.intValue()
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateOrder(
            @PathVariable Long id,
            @RequestBody OrderRequest orderRequest
    ) {
        return GetResponse.responseObject(
                "Successfully update order id ",
                id.intValue(),
                orderService.updateOrder(id, orderRequest)
        );
    }

}
