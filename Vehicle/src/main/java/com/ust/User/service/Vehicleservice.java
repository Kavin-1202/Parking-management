package com.ust.User.service;

import com.ust.User.dto.BookingDto;
import com.ust.User.dto.FullResponse;
import com.ust.User.feign.BookingClient;
import com.ust.User.model.Vehicle;
import com.ust.User.repository.Vehiclerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vehicleservice {
    @Autowired
    private Vehiclerepo repo;
    @Autowired
    private BookingClient bkclient;
    public Vehicle createVehicle(Vehicle vehicle) {
        return repo.save(vehicle);
    }
    public List<Vehicle> getVehicles() {
        return repo.findAll();
    }
    public Vehicle getVehicleById(Long id){
        return repo.findByVehicleid(id);
    }
    public FullResponse getVehicleDetails(Long vehicleId) {
        // Fetch vehicle details from your repository
        Vehicle vehicle = repo.findById(vehicleId).orElse(null);
        FullResponse res=new FullResponse();
        res.setVehicle(vehicle);
        // Fetch bookings
        List<BookingDto> bookings = bkclient.getBookingsByVehicleId(vehicleId);
        res.setBooking(bookings);
        return res;
    }
}
