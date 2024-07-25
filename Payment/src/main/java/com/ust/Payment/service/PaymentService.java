package com.ust.Payment.service;

import com.ust.Payment.dto.BookingDto;
import com.ust.Payment.dto.FullResponse;
import com.ust.Payment.dto.ParkingDto;
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
        BookingDto booking=bookingClient.getBookingById(payment.getBookid());
        if(booking.getStatus().equalsIgnoreCase("PaymentPending")){
            Payment savedPayment = paymentRepository.save(payment);
            bookingClient.paymentConfirmed(savedPayment.getBookid());
            return savedPayment;
        }
        return null;
    }

    public Payment getByPayId(Long payid)
    {
        return paymentRepository.findByPayid(payid);
    }
}
