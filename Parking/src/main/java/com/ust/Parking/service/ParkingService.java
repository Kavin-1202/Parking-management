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
    public Parking getParkingById(Long parkingid) {
        return parkingRepository.findByParkingid(parkingid);
    }
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }
    public Parking save(Parking parking) {
        return parkingRepository.save(parking);
    }
    public int getAvailableSpots(Long parkingId, String Type) {
        Parking parking = getParkingById(parkingId);
        return Type.equalsIgnoreCase("2-wheeler") ? parking.getAvailable_two_wheeler_spots() : parking.getAvailable_four_wheeler_spots();
    }
    public boolean isParkingAvailable(Long parkingId, String Type) {
        return getAvailableSpots(parkingId, Type) >= 1;
    }
    public void updateParkingAvailabilityAdd(Long parkingid, String Type) {
        Parking parking = parkingRepository.findById(parkingid)
                .orElseThrow(null);

        if (Type.equalsIgnoreCase("2-wheeler")) {
            parking.setAvailable_two_wheeler_spots(parking.getAvailable_two_wheeler_spots() + 1);
        } else if (Type.equalsIgnoreCase("4-wheeler")) {
            parking.setAvailable_four_wheeler_spots(parking.getAvailable_four_wheeler_spots() + 1);
        } else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
        parkingRepository.save(parking);
    }
    public void updateParkingAvailabilityRemove(Long parkingid, String Type) {
        Parking parking = parkingRepository.findById(parkingid)
                .orElseThrow(null);

        if (Type.equalsIgnoreCase("2-wheeler")) {
            parking.setAvailable_two_wheeler_spots(parking.getAvailable_two_wheeler_spots() - 1);
        } else if (Type.equalsIgnoreCase("4-wheeler")) {
            parking.setAvailable_four_wheeler_spots(parking.getAvailable_four_wheeler_spots() - 1);
        } else {
            throw new IllegalArgumentException("Invalid vehicle type");
        }
        parkingRepository.save(parking);
    }

    public Parking findByName(String parkingname) {
        return parkingRepository.findByParkingname(parkingname);
    }

    public Parking findById(Long parkingid) {
        return parkingRepository.findById(parkingid).orElse(null);
    }
}
