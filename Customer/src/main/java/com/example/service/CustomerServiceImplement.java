package com.example.service;

import com.example.model.Customer;
import com.example.model.request.CustomerRequest;
import com.example.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImplement implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        return customerRepository.save(customerRequest.toEntity());
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer updateCustomerById(Long id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id).orElse(null);
        customer.setEmail(customerRequest.getEmail());
        customer.setName(customerRequest.getName());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
