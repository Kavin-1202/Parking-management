package com.ust.Booking.client;

import lombok.Data;

@Data
public class ParkingDto {
    private Long parkingid;
    private String location;
    private int twoWheelerCapacity;
    private int fourWheelerCapacity;
    private int availableTwoWheelerSpots;
    private int availableFourWheelerSpots;
}
