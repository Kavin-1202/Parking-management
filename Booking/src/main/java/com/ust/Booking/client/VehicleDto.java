package com.ust.Booking.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Long vehicleid;
    private String registernumber;
    private String type;
    private String ownername;
    private String status;
}
