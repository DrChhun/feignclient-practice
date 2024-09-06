package com.example.client;

import com.example.model.response.productRes.ProductServiceRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:8020/api/v1")
public interface ProductClient {

    @GetMapping("/product/{id}")
    ProductServiceRes getProductById(@PathVariable Long id);

}
