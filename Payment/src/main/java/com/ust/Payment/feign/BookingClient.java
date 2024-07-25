package com.ust.Payment.feign;

import com.ust.Payment.dto.BookingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "booking",url = "http://localhost:9097/booking")
public interface BookingClient{
    @GetMapping("/{bookid}")
    public BookingDto getBookingById(@PathVariable("bookid") Long bookid);
    @PostMapping("/{bookid}/payment-confirmed")
    void paymentConfirmed(@PathVariable("bookid") Long bookid);
}
