package com.ust.User.dto;

import com.ust.User.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullResponse {
    private Vehicle vehicle;
    private List<Booking> booking;
    private List<Payment> payments;

}
