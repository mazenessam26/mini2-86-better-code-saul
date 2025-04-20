package com.example.demo.repositories;
import com.example.demo.models.customers;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<customers, Long> {

    // Find customers by email domain
    List<customers> findByEmailEndingWith(String domain);

    // Find customers by phone prefix
    List<customers> findByPhoneNumberStartingWith(String prefix);
}

