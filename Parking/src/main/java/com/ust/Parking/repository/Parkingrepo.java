package com.ust.Parking.repository;

import com.ust.Parking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Parkingrepo extends JpaRepository<Parking,Long> {
    Parking findByParkingname(String parkingname);

    Parking findByParkingid(Long parkingid);
}
