package com.example.service;

import com.example.model.Product;
import com.example.model.request.ProductRequest;
import com.example.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplement implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductRequest productRequest) {
        return productRepository.save(productRequest.toEntity());
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProductById(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElse(null);
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        return productRepository.save(product);
    }
}
