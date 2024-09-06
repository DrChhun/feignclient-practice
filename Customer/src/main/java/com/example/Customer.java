package com.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Customer Service", version = "1.0", description = "Customer Service"))
public class Customer {
    public static void main(String[] args) {
        SpringApplication.run(Customer.class, args);
    }
}