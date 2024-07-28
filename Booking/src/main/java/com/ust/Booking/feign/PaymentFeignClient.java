package com.ust.Booking.feign;

import com.ust.Booking.client.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="payment",url="http://localhost:9098/payment")
public interface PaymentFeignClient {
    @GetMapping("/booking/allpayments/{bookid}")
    public Payment getPaymentsByBookingid(@PathVariable("bookid") Long bookid);

}
