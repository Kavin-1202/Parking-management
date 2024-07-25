package com.ust.Payment.dto;

import lombok.Data;

@Data
public class BookingDto {
    private Long bookid;
    private Long vehicleid;
    private Long parkingid;
    private String starttime;
    private String endtime;
    private String status;
}
