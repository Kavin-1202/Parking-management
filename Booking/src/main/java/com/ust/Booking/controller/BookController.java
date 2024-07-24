package com.ust.Booking.controller;

import com.ust.Booking.model.Booking;
import com.ust.Booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/booking")
public class BookController {

    @Autowired
    private BookingService bookingService;
    @GetMapping("/allbookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable("bookid") Long bookid) {
        return bookingService.getBookingById(bookid);
    }

    @PostMapping("/book")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{id}/status")
    public Booking updateBookingStatus(@PathVariable("bookid") Long bookid, @RequestParam("status") String status) {
        return bookingService.updateBookingStatus(bookid, status);
    }

    @PutMapping("/{id}/confirm")
    public Booking confirmBooking(@PathVariable("bookid") Long bookid) {
        return bookingService.confirmBooking(bookid);
    }

    @PutMapping("/{bookid}/complete")
    public Booking completeBooking(@PathVariable("bookid") Long bookid) {
        return bookingService.completeBooking(bookid);
    }

    @PostMapping("/{bookid}/payment-confirmed")
    public void paymentConfirmed(@PathVariable("bookid") Long bookid) {
        bookingService.confirmBooking(bookid);
    }
}