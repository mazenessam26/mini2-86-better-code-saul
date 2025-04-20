package com.example.demo.repositories;
import com.example.demo.models.payments;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<payments, Long> {

    // Find payments by trip ID
    List<payments> findByTripId(Long tripId);


    // Find payments with amount above threshold
    List<payments> findByAmountGreaterThan(Double threshold);

}

