package com.ust.Payment.controller;

import com.ust.Payment.feign.BookingClient;
import com.ust.Payment.model.Payment;
import com.ust.Payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{payid}")
    public Payment getByPayId(@PathVariable("payid") Long payid) {
        return paymentService.getByPayId(payid);
    }

    @PostMapping("/payment-confirmed")
    public Payment createPayment(@RequestBody Payment payment)
    {
        return paymentService.createPayment(payment);
    }
}
