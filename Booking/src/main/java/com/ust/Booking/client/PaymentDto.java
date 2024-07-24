package com.ust.Booking.client;

import lombok.Data;

@Data
public class PaymentDto {
    private Long payId;
    private Long bookId;
    private double amount;
    private String payStatus; // "Pending", "Completed"

}
