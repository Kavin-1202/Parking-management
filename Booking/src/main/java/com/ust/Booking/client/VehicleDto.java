package com.ust.Booking.client;

import lombok.Data;

@Data
public class VehicleDto {

    private Long vehicleid;
    private String registernumber;
    private String type;
    private String ownername;
    private String status;
}
