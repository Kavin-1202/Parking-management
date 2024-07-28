package com.ust.Booking.client;

import lombok.Data;

@Data
public class Payment {
    private Long payid;
    private Long bookid;
    private double amount;
}
