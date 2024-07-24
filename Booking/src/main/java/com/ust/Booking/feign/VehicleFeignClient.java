package com.ust.Booking.feign;

import com.ust.Booking.client.VehicleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vehicle",url = "http://localhost:9095/vehicle")
public interface VehicleFeignClient {
    @GetMapping("{id}")
    VehicleDto getVehicle(@PathVariable("id") Long id);
}
