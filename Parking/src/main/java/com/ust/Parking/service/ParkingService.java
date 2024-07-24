package com.ust.Parking.service;

import com.ust.Parking.model.Parking;
import com.ust.Parking.repository.Parkingrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {
    @Autowired
    private Parkingrepo parkingRepository;
    public Parking getParkingById(Long id) {
        return parkingRepository.findById(id).orElse(null);
    }
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }
    public Parking save(Parking parking) {
        return parkingRepository.save(parking);
    }
    public int getAvailableSpots(Long parkingId, String Type) {
        Parking parking = getParkingById(parkingId);
        return Type.equalsIgnoreCase("2-wheeler") ? parking.getAvailableTwoWheelerSpots() : parking.getAvailableFourWheelerSpots();
    }
    public boolean isParkingAvailable(Long parkingId, String Type) {
        return getAvailableSpots(parkingId, Type) >= 1;
    }
    public void updateParkingAvailability(Long parkingId, String Type, int spots) {
        Parking parking = parkingRepository.findById(parkingId)
                .orElseThrow(null);

        if (Type.equalsIgnoreCase("2-wheeler")) {
            parking.setAvailableTwoWheelerSpots(parking.getAvailableTwoWheelerSpots() + spots);
        } else if (Type.equalsIgnoreCase("4-wheeler")) {
            parking.setAvailableFourWheelerSpots(parking.getAvailableFourWheelerSpots() + spots);
        } else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
        parkingRepository.save(parking);
    }
}
