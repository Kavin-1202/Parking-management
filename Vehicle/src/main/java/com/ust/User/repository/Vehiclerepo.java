package com.ust.User.repository;

import com.ust.User.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Vehiclerepo extends JpaRepository<Vehicle,Long> {
    Vehicle findByVehicleid(Long vehicleid);
}
