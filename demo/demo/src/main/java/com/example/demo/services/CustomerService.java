package com.example.demo.services;

import com.example.demo.models.Customer;
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
    public Customer addCustomer(Customer Customer) {
        return customerRepository.save(Customer);
    }

    // 8.2.2.2 Get All Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // 8.2.2.3 Get Customer By ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    // 8.2.2.4 Update Customer
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = getCustomerById(id);
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        return customerRepository.save(existingCustomer);
    }

    // 8.2.2.5 Delete Customer
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
        customerRepository.deleteById(id);
    }

    // 8.2.2.6 Find Customers By Email Domain
    public List<Customer> findCustomersByEmailDomain(String domain) {
        return customerRepository.findByEmailEndingWith(domain);
    }

    // 8.2.2.7 Find Customers By Phone Prefix
    public List<Customer> findCustomersByPhoneNumberStartingWith(String prefix) {
        return customerRepository.findByPhoneNumberStartingWith(prefix);
    }
}

