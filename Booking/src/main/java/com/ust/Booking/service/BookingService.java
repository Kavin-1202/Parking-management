package com.ust.Booking.service;

import com.ust.Booking.client.ParkingDto;
import com.ust.Booking.client.VehicleDto;
import com.ust.Booking.feign.ParkingFeignClient;
import com.ust.Booking.feign.VehicleFeignClient;
import com.ust.Booking.model.Booking;
import com.ust.Booking.repository.Bookingrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class BookingService {

    @Autowired
    private Bookingrepo bookingRepository;

    @Autowired
    private VehicleFeignClient vehicleClient;

    @Autowired
    private ParkingFeignClient parkingClient;

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(null);
    }

    public Booking createBooking(Booking booking) {
        VehicleDto vehicle = vehicleClient.getVehicle(booking.getVehicleid());
        boolean available = parkingClient.isParkingAvailable(booking.getParkingid(), vehicle.getType(), 1);  // Assuming 1 spot per booking
        if (!available) {
            return null;
        }
        booking.setStatus("Pending"); // Set initial status
        return bookingRepository.save(booking);
    }

    public Booking updateBookingStatus(Long bookingId, String status) {
        Booking booking = getBookingById(bookingId);
        booking.setStatus(status);
        return bookingRepository.save(booking);
    }

    public Booking confirmBooking(Long bookingId) {
        Booking booking = getBookingById(bookingId);
        booking.setStatus("Confirmed");
        return bookingRepository.save(booking);
    }

    public Booking completeBooking(Long bookingId) {
        Booking booking = getBookingById(bookingId);
        if (LocalDateTime.parse(booking.getEndtime()).isBefore(LocalDateTime.now())) {
            booking.setStatus("Completed");
            bookingRepository.save(booking);
            VehicleDto vehicle = vehicleClient.getVehicle(booking.getVehicleid());
            parkingClient.updateParkingAvailability(booking.getParkingid(), vehicle.getType(), 1); // Re-add 1 spot
            return booking;
        } else {
            throw new RuntimeException("Booking end time is not yet reached.");
        }
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
