package com.example.service;

import com.example.model.Product;
import com.example.model.request.ProductRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest productRequest);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    void deleteProductById(Long id);

    Product updateProductById(Long id, ProductRequest productRequest);
}
