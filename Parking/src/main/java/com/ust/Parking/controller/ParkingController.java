package com.ust.Parking.controller;

import com.ust.Parking.model.Parking;
import com.ust.Parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;
    @GetMapping
    public List<Parking> getAllParkingSpots() {
        return parkingService.findAll();
    }
    @PostMapping
    public Parking addParkingSpot(@RequestBody Parking parking) {
        return parkingService.save(parking);
    }
    @GetMapping("/{id}/available-spots")
    public int getAvailableSpots(@PathVariable("id") Long id, @RequestParam("Type") String Type) {
        return parkingService.getAvailableSpots(id, Type);
    }

    @GetMapping("/{id}/is-available")
    public boolean isParkingAvailable(@PathVariable("id") Long id, @RequestParam("Type") String Type) {
        return parkingService.isParkingAvailable(id, Type);
    }
    @PatchMapping("/{id}/update-availability")
    public void updateParkingAvailability(@PathVariable("id") Long id,
                                          @RequestParam("Type") String Type,
                                          @RequestParam("spots") int spots) {
        parkingService.updateParkingAvailability(id, Type, spots);
    }
}
