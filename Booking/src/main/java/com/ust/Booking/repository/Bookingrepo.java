package com.ust.Booking.repository;

import com.ust.Booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookingrepo extends JpaRepository<Booking,Long> {
}
