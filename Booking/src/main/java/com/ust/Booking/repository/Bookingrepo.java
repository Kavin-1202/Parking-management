package com.ust.Booking.repository;

import com.ust.Booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Bookingrepo extends JpaRepository<Booking,Long> {
    Booking findByBookid(Long bookid);

    List<Booking> findByVehicleid(Long vehicleid);
}
