package com.example.controller;

import com.example.model.request.ProductRequest;
import com.example.model.response.GetResponse;
import com.example.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest) {
        return GetResponse.responseCreate(
                "Successfully created product",
                productService.createProduct(productRequest)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        return GetResponse.responseList(
                "Successfully get all products",
                productService.getAllProducts(),
                productService.getAllProducts().size()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return GetResponse.responseObject(
                "Successfully get product by id ",
                id.intValue(),
                productService.getProductById(id)
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return GetResponse.responseDelete(
                "Successfully delete product by id ",
                id.intValue()
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<?> udpateProductById(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return GetResponse.responseObject(
                "Successfully update product by id ",
                id.intValue(),
                productService.updateProductById(id, productRequest)
        );
    }
}
