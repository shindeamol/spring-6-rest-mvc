package com.example.spring6restmvc.services;

import com.example.spring6restmvc.models.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomer(UUID id);

    Customer saveNewCustomer(Customer customer);

    Customer updateCustomer(UUID id, Customer customer);

    void deleteCustomer(UUID id);

    Customer patchCustomer(UUID id, Customer customer);
}
