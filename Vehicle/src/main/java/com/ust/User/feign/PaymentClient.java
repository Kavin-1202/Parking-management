package com.ust.User.feign;

import com.ust.User.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="payment",url="http://localhost:9098/payment")
public interface PaymentClient {
    @GetMapping("/booking/{bookid}/allpayments")
    public List<Payment> getPaymentsByBookingid(@PathVariable("bookid") Long bookid);
}
