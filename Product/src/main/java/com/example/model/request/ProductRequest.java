package com.example.model.request;

import com.example.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequest {
    private String name;
    private Double price;

    public Product toEntity() {
        return Product.builder()
                .id(null)
                .name(this.name)
                .price(this.price)
                .build();
    }
}
