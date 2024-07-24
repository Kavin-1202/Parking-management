package com.ust.User.service;

import com.ust.User.model.Vehicle;
import com.ust.User.repository.Vehiclerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vehicleservice {
    @Autowired
    private Vehiclerepo repo;
    public Vehicle createVehicle(Vehicle vehicle) {
        return repo.save(vehicle);
    }
    public List<Vehicle> getVehicles() {
        return repo.findAll();
    }
    public Vehicle getVehicleById(Long id){
        return repo.findByVehicleid(id);
    }

}
