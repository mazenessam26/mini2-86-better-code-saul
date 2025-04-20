package com.example.demo.services;

import com.example.demo.models.customers;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 8.2.2.1 Add Customer
    public customers addCustomer(customers customers) {
        return customerRepository.save(customers);
    }

    // 8.2.2.2 Get All Customers
    public List<customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    // 8.2.2.3 Get Customer By ID
    public customers getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    // 8.2.2.4 Update Customer
    public customers updateCustomer(Long id, customers updatedCustomers) {
        customers existingCustomers = getCustomerById(id);
        existingCustomers.setName(updatedCustomers.getName());
        existingCustomers.setEmail(updatedCustomers.getEmail());
        existingCustomers.setPhoneNumber(updatedCustomers.getPhoneNumber());
        return customerRepository.save(existingCustomers);
    }

    // 8.2.2.5 Delete Customer
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
        customerRepository.deleteById(id);
    }

    // 8.2.2.6 Find Customers By Email Domain
    public List<customers> findCustomersByEmailDomain(String domain) {
        return customerRepository.findByEmailEndingWith(domain);
    }

    // 8.2.2.7 Find Customers By Phone Prefix
    public List<customers> findCustomersByPhoneNumberStartingWith(String prefix) {
        return customerRepository.findByPhoneNumberStartingWith(prefix);
    }
}

