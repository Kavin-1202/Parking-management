package com.ust.Payment.controller;

import com.ust.Payment.feign.BookingClient;
import com.ust.Payment.model.Payment;
import com.ust.Payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{payid}")
    public Payment getByPayId(@PathVariable("payid") Long payid) {
        return paymentService.getByPayId(payid);
    }

    @GetMapping("/booking/allpayments/{bookid}")
    public Payment getPaymentsByBookingid(@PathVariable("bookid") Long bookid){
        return paymentService.getPaymentsByBookingid(bookid);
    }

    @PostMapping("/payment-confirmed")
    public Payment createPayment(@RequestBody Payment payment)
    {
        return paymentService.createPayment(payment);
    }
}
