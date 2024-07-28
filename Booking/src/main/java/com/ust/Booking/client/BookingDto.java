package com.ust.Booking.client;

import com.ust.Booking.model.Booking;
import lombok.Data;

@Data
public class BookingDto {
    private Long bookid;
    private Long vehicleid;
    private Long parkingid;
    private String starttime;
    private String endtime;
    private String status;
    private Parking parking;
    private Payment payment;
}
