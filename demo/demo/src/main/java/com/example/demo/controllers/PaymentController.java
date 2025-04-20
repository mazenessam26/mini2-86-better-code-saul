package com.example.demo.controllers;

import com.example.demo.models.payments;
import com.example.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // 9.4.2.1 Add Payment
    @PostMapping("/addPayment")
    public payments addPayment(@RequestBody payments payments) {
        return paymentService.addPayment(payments);
    }

    // 9.4.2.2 Get All Payments
    @GetMapping("/allPayments")
    public List<payments> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // 9.4.2.3 Get Specific Payment
    @GetMapping("/{id}")
    public payments getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // 9.4.2.4 Update Payment
    @PutMapping("/update/{id}")
    public payments updatePayment(@PathVariable Long id, @RequestBody payments payments) {
        return paymentService.updatePayment(id, payments);
    }

    // 9.4.2.5 Delete Payment
    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment with ID " + id + " deleted successfully.";
    }

    // 9.4.2.6 Find Payments By Trip ID
    @GetMapping("/findByTripId")
    public List<payments> findPaymentsByTripId(@RequestParam Long tripId) {
        return paymentService.findPaymentsByTripId(tripId);
    }

    // 9.4.2.7 Find Payments With an Amount Greater Than a Threshold
    @GetMapping("/findByAmountThreshold")
    public List<payments> findPaymentsWithAmountGreaterThan(@RequestParam Double threshold) {
        return paymentService.findByAmountThreshold(threshold);
    }
}
