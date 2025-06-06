package com.example.spring6restmvc.controllers;

import com.example.spring6restmvc.models.Customer;
import com.example.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> getCustomers() {
        log.debug("Get customers");
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") UUID customerId) {
        log.debug("Get customer with id {}", customerId);
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public ResponseEntity<Customer> handleCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.saveNewCustomer(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable UUID customerId) {
        log.debug("Update customer with id {}", customerId);

        Customer updatedCustomer = customerService.updateCustomer(customerId, customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable UUID customerId) {
        log.debug("Delete customer with id {}", customerId);
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<Customer> patchCustomer(@RequestBody Customer customer, @PathVariable UUID customerId) {
        log.debug("Patch customer with id {}", customerId);
        Customer updatedCustomer = customerService.updateCustomer(customerId, customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);
    }
}
