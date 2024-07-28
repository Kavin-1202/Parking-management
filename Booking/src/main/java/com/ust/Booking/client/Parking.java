package com.ust.Booking.client;

import lombok.Data;

@Data
public class Parking {
    private Long parkingid;
    private String parkingname;
    private String location;
    private int available_two_wheeler_spots;
    private int available_four_wheeler_spots;
}
