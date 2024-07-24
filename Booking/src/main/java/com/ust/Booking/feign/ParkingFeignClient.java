package com.ust.Booking.feign;

import com.ust.Booking.client.ParkingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "parking",url = "http://localhost:9096/parking")
public interface ParkingFeignClient {
    @GetMapping("/{id}")
    ParkingDto getParkingById(@PathVariable("id") Long id);
    @GetMapping("/{id}/is-available")
    boolean isParkingAvailable(@PathVariable("id") Long id, @RequestParam("Type") String Type, @RequestParam("requiredspots") int requiredspots);
    @PatchMapping("/{id}/update-availability")
    void updateParkingAvailability(@PathVariable("id") Long id,
                                   @RequestParam("Type") String vehicleType,
                                   @RequestParam("spots") int spots);
}
