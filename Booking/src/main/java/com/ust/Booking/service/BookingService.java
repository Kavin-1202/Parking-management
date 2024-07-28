package com.ust.Booking.service;

import com.ust.Booking.client.BookingDto;
import com.ust.Booking.client.Parking;
import com.ust.Booking.client.Payment;
import com.ust.Booking.client.VehicleDto;
import com.ust.Booking.feign.ParkingFeignClient;
import com.ust.Booking.feign.PaymentFeignClient;
import com.ust.Booking.feign.VehicleFeignClient;
import com.ust.Booking.model.Booking;
import com.ust.Booking.repository.Bookingrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private Bookingrepo bookingRepository;

    @Autowired
    private VehicleFeignClient vehicleClient;

    @Autowired
    private ParkingFeignClient parkingClient;
    @Autowired
    private PaymentFeignClient paymentClient;

    public Booking getBookingById(Long bookid) {
        return bookingRepository.findByBookid(bookid);
    }
    public Parking getParkingByBookingId(Long bookid){
        Booking book=bookingRepository.findByBookid(bookid);
        return parkingClient.getParkingById(book.getParkingid());
    }

    public Booking createBooking(Booking booking) {
        VehicleDto vehicle = vehicleClient.getVehicle(booking.getVehicleid());
        boolean available = parkingClient.isParkingAvailable(booking.getParkingid(), vehicle.getType(), 1);  // Assuming 1 spot per booking
        if (!available) {
            return null;
        }
        booking.setStatus("PaymentPending"); // Set initial status
        return bookingRepository.save(booking);
    }

    public Booking completeBooking(Long bookingId) {
        Booking booking = getBookingById(bookingId);
        booking.setStatus("Completed");
        bookingRepository.save(booking);
        VehicleDto vehicle=vehicleClient.getVehicle(booking.getVehicleid());
        parkingClient.AddOneParkingAvailability(booking.getParkingid(), vehicle.getType());
        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void confirmBooking(Long bookid) {
        Booking booking = getBookingById(bookid);
        booking.setStatus("PaymentCompleted");
        VehicleDto vehicle = vehicleClient.getVehicle(booking.getVehicleid());
        parkingClient.RemoveOneParkingAvailability(booking.getParkingid(), vehicle.getType());
        bookingRepository.save(booking);
    }

    public List<BookingDto> getBookingsByVehicleId(Long vehicleid) {
        List<Booking> bookings=bookingRepository.findByVehicleid(vehicleid);
        List<BookingDto> dtos=new ArrayList<>();
        for(Booking book : bookings){
            BookingDto dto=new BookingDto();
            dto.setBookid(book.getBookid());
            dto.setVehicleid(book.getVehicleid());
            dto.setParkingid(book.getParkingid());
            dto.setStarttime(book.getStarttime());
            dto.setEndtime(book.getEndtime());
            dto.setStatus(book.getStatus());
            Parking parkingDto = getParkingByBookingId(book.getBookid());
            dto.setParking(parkingDto);
            Payment payment= paymentClient.getPaymentsByBookingid(book.getBookid());
            dto.setPayment(payment);
            dtos.add(dto);
        }
        return dtos;
    }
}
