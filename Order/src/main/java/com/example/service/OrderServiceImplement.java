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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImplement implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final com.example.Order order;

    @Override
    public OrderCreateResDTO createOrder(OrderRequest orderRequest) {
        Order saveOrder = orderRepository.save(orderRequest.toEntity());

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
                .customerResponse(customerClient.getCustomerById(orderRequest.getCustomerId()).toCustomerResDTO())
                .productResponses(productDataList.stream().map(ProductServiceRes::toProductResDTO).toList())
                .build();
    }

    @Override
    public List<OrderCreateResDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(order -> OrderCreateResDTO.builder()
                        .id(order.getId())
                        .customerResponse(customerClient.getCustomerById(order.getCustomerId()).toCustomerResDTO())
                        .productResponses(order.getProductIds().stream().map(productId -> {
                            ProductServiceRes productData = productClient.getProductById(productId);
                            return productData.toProductResDTO();
                        }).toList())
                        .build()).toList();
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderCreateResDTO updateOrder(Long id, OrderRequest orderRequest) {
        Order order = orderRepository.findById(id).orElse(null);
        order.setOrderDate(LocalDate.now());
        order.setCustomerId(orderRequest.getCustomerId());
        order.setProductIds(orderRequest.getProductIds());
        orderRepository.save(order);

        List<ProductServiceRes> productDataList = new ArrayList<>();
        for (Long productId : orderRequest.getProductIds()) {
            ProductServiceRes productData = productClient.getProductById(productId);
            productDataList.add(productData);
        }

        return OrderCreateResDTO.builder()
                .id(order.getId())
                .customerResponse(customerClient.getCustomerById(orderRequest.getCustomerId()).toCustomerResDTO())
                .productResponses(productDataList.stream().map(ProductServiceRes::toProductResDTO).toList())
                .build();
    }

    @Override
    public OrderCreateResDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id).get();

        return OrderCreateResDTO.builder()
                .id(order.getId())
                .customerResponse(customerClient.getCustomerById(order.getCustomerId()).toCustomerResDTO())
                .productResponses(order.getProductIds().stream().map(productId -> {
                    ProductServiceRes productData = productClient.getProductById(productId);
                    return productData.toProductResDTO();
                }).toList())
                .build();
    }
}
