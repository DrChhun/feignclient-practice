package com.example.service;

import com.example.model.Customer;
import com.example.model.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerRequest customerRequest);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer updateCustomerById(Long id, CustomerRequest customerRequest);

    void deleteCustomerById(Long id);
}
