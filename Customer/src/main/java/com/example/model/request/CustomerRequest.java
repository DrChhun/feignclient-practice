package com.example.model.request;

import com.example.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerRequest {
    private String name;
    private String email;

    public Customer toEntity() {
        return Customer.builder()
                .id(null)
                .name(this.name)
                .email(this.email)
                .build();
    }
}
