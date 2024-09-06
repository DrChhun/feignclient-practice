package com.example.model.request;

import com.example.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderRequest {
    private Long customerId;
    private List<Long> productIds;
    private LocalDate orderDate;

    public Order toEntity() {
        return Order.builder()
                .id(null)
                .customerId(this.customerId)
                .productIds(this.productIds)
                .orderDate(LocalDate.now())
                .build();
    }
}
