package com.example.demo.repositories;
import com.example.demo.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find payments by trip ID
    List<Payment> findByTripId(Long tripId);


    // Find payments with amount above threshold
    List<Payment> findByAmountGreaterThan(Double threshold);

}

