package com.example.demo.repositories;
import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find customers by email domain
    List<Customer> findByEmailEndingWith(String domain);

    // Find customers by phone prefix
    List<Customer> findByPhoneNumberStartingWith(String prefix);
}

