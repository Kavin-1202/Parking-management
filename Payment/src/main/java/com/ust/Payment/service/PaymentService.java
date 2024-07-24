package com.ust.Payment.service;

import com.ust.Payment.feign.BookingClient;
import com.ust.Payment.model.Payment;
import com.ust.Payment.repository.Paymentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private Paymentrepo paymentRepository;

    @Autowired
    private BookingClient bookingClient;

    public Payment createPayment(Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        /*if (savedPayment.getPaystatus().equalsIgnoreCase("Completed")) {
            bookingClient.paymentConfirmed(savedPayment.getBookid());
        }*/
        bookingClient.paymentConfirmed(savedPayment.getBookid());
        return savedPayment;
    }

    public Payment getPaymentByBookingId(Long bookid)
    {
        return paymentRepository.findByBookid(bookid);
    }
}
