package com.ust.User.feign;

import com.ust.User.dto.BookingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "booking",url ="http://localhost:9097/booking")
public interface BookingClient {
    @GetMapping("/vehicle/{vehicleid}")
    public List<BookingDto> getBookingsByVehicleId(@PathVariable("vehicleid") Long vehicleid);

}
