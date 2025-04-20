package com.example.demo.services;

import com.example.demo.models.payments;
import com.example.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // 8.4.2.1 Add Payment
    public payments addPayment(payments payments) {
        return paymentRepository.save(payments);
    }

    // 8.4.2.2 Get All Payments
    public List<payments> getAllPayments() {
        return paymentRepository.findAll();
    }

    // 8.4.2.3 Get Payment By ID
    public payments getPaymentById(Long id) {
        Optional<payments> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.orElse(null);
    }

    // 8.4.2.4 Update Payment
    public payments updatePayment(Long id, payments updatedPayments) {
        return paymentRepository.findById(id).map(payments -> {
            payments.setAmount(updatedPayments.getAmount());
            payments.setPaymentMethod(updatedPayments.getPaymentMethod());
            payments.setPaymentStatus(updatedPayments.getPaymentStatus());
            payments.setTrip(updatedPayments.getTrip());
            return paymentRepository.save(payments);
        }).orElse(null);
    }

    // 8.4.2.5 Delete Payment
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    // 8.4.2.6 Find Payments By Trip ID
    public List<payments> findPaymentsByTripId(Long tripId) {
        // Make sure the repository method returns a list instead of a single object
        return paymentRepository.findAll().stream()
                .filter(payments -> payments.getTrip() != null && payments.getTrip().getId().equals(tripId))
                .toList();
    }

    // 8.4.2.7 Find Payments With an Amount Greater Than a Threshold
    public List<payments> findByAmountThreshold(Double threshold) {
        return paymentRepository.findByAmountGreaterThan(threshold);
    }
}
