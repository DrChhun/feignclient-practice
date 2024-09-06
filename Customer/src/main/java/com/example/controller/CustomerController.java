package com.example.controller;

import com.example.model.request.CustomerRequest;
import com.example.model.response.GetResponse;
import com.example.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest customerRequest) {
        return GetResponse.responseCreate(
                "Successfully created customer",
                customerService.createCustomer(customerRequest)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCustomers() {
        return GetResponse.responseList(
                "Successfully get all customers",
                customerService.getAllCustomers(),
                customerService.getAllCustomers().size()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        return GetResponse.responseObject(
                "Successfully get customer",
                id.intValue(),
                customerService.getCustomerById(id)
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return GetResponse.responseDelete(
                "Successfully delete customer id : ",
                id.intValue()
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCustomerById(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        return GetResponse.responseObject(
                "Successfully update customer id : ",
                id.intValue(),
                customerService.updateCustomerById(id, customerRequest)
        );
    }
}
