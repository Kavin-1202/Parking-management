package com.ust.Booking.feign;

import com.ust.Booking.client.ParkingDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "parking",url = "http://localhost:9096/parking")
public interface ParkingFeignClient {
    @GetMapping("/{id}")
    ParkingDto getParkingById(@PathVariable("id") Long id);
    @GetMapping("/{id}/is-available")
    boolean isParkingAvailable(@PathVariable("id") Long id, @RequestParam("Type") String Type, @RequestParam("requiredspots") int requiredspots);
    @PutMapping("/{parkingid}/add-availability")
    public void AddOneParkingAvailability(@PathVariable("parkingid") Long parkingid,
                                          @RequestParam("Type") String Type);
    @PutMapping("/{parkingid}/remove-availability")
    public void RemoveOneParkingAvailability(@PathVariable("parkingid") Long parkingid,
                                             @RequestParam("Type") String Type);
}
