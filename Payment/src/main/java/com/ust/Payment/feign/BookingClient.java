package com.ust.Payment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "booking",url = "http://localhost:9097/booking")
public interface BookingClient{
    @PostMapping("/{bookid}/payment-confirmed")
    void paymentConfirmed(@PathVariable("bookid") Long bookid);
}
