package com.ust.Payment.dto;

import lombok.Data;

@Data
public class ParkingDto {
    private Long parking_id;
    private String parkingname;
    private String location;
    private Long bookid;
}
