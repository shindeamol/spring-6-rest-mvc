package com.example.spring6restmvc.services;

import com.example.spring6restmvc.models.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final Map<UUID, Customer> customers;

    public CustomerServiceImpl() {
        customers = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .name("John Doe")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Richard Smith")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Jack Smith")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        customers.put(customer1.getId(), customer1);
        customers.put(customer2.getId(), customer2);
        customers.put(customer3.getId(), customer3);
    }

    @Override
    public List<Customer> getCustomers() {
        log.debug("Get customers");
        return customers.values().stream().toList();
    }

    @Override
    public Customer getCustomer(UUID id) {
        log.debug("Get customer with id {}", id);
        return customers.get(id);
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        log.debug("Save new customer");

        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .name(customer.getName())
                .version(customer.getVersion())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        customers.put(savedCustomer.getId(), savedCustomer);
        return customers.get(savedCustomer.getId());
    }

    @Override
    public Customer updateCustomer(UUID id, Customer customer) {
        Customer updatedCustomer = customers.get(id);
        updatedCustomer.setName(customer.getName());
        updatedCustomer.setUpdatedDate(LocalDateTime.now());

        customers.put(updatedCustomer.getId(), updatedCustomer);

        return updatedCustomer;
    }

    @Override
    public void deleteCustomer(UUID id) {
        log.debug("Delete customer with id {}", id);
        customers.remove(id);
    }

    @Override
    public Customer patchCustomer(UUID id, Customer customer) {
        Customer updatedCustomer = customers.get(id);

        if (StringUtils.hasText(customer.getName())){
            updatedCustomer.setName(customer.getName());
        }

        updatedCustomer.setUpdatedDate(LocalDateTime.now());

        customers.put(updatedCustomer.getId(), updatedCustomer);

        return updatedCustomer;
    }
}
