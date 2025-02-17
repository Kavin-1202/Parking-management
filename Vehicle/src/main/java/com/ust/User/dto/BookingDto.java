package com.ust.User.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
