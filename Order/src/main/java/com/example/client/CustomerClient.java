package com.example.client;

import com.example.model.response.customerRes.CustomerServiceRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "http://localhost:8010/api/v1")
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    CustomerServiceRes getCustomerById(@PathVariable Long id);

}
