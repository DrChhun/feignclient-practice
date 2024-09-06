package com.example.model.response.productRes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductServiceRes {
    private String message;
    private ProductResDTO payload;
    private HttpStatus status;
    private LocalDateTime time;

    public ProductResDTO toProductResDTO() {
        return ProductResDTO.builder()
                .id(this.payload.getId())
                .name(this.payload.getName())
                .price(this.payload.getPrice())
                .build();
    }
}
