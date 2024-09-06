package com.example.model.response.customerRes;

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
public class CustomerServiceRes {
    private String message;
    private CustomerResDTO payload;
    private HttpStatus status;
    private LocalDateTime times;

    public CustomerResDTO toCustomerResDTO() {
        return CustomerResDTO.builder()
                .id(this.payload.getId())
                .email(this.payload.getEmail())
                .name(this.payload.getName())
                .build();
    }
}
