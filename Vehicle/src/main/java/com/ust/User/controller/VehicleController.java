package com.ust.User.controller;

import com.ust.User.model.Vehicle;
import com.ust.User.service.Vehicleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private Vehicleservice vehicleService;
    @GetMapping("/list")
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }
    @PostMapping("/addvehicle")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }
    @GetMapping("{id}")
    public Vehicle getVehicle(@PathVariable Long id){
        return vehicleService.getVehicleById(id);
    }
}
