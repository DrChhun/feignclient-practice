package com.example.service;

import com.example.client.CustomerClient;
import com.example.client.ProductClient;
import com.example.model.Order;
import com.example.model.request.OrderRequest;
import com.example.model.response.customerRes.CustomerServiceRes;
import com.example.model.response.orderRes.OrderCreateResDTO;
import com.example.model.response.productRes.ProductServiceRes;
import com.example.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImplement implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    @Override
    public OrderCreateResDTO createOrder(OrderRequest orderRequest) {
        Order saveOrder = orderRepository.save(orderRequest.toEntity());
        CustomerServiceRes getCustomer = customerClient.getCustomerById(orderRequest.getCustomerId());

        //fetch product data form client using loop
        //let say the array have 1 value
        //loop the value and do the request to the client
        List<ProductServiceRes> productDataList = new ArrayList<>();
        for (Long productId : orderRequest.getProductIds()) {
            ProductServiceRes productData = productClient.getProductById(productId);
            productDataList.add(productData);
        }
//        System.out.println(orderRequest.getProductIds().size());

        //then store that response from the client endpoint
        //to the list and then use that list to response back to the controller

        return OrderCreateResDTO.builder()
                .id(saveOrder.getId())
                .customerResponse(getCustomer.toCustomerResDTO())
                .productResponses(productDataList.stream().map(ProductServiceRes::toProductResDTO).toList())
                .build();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
