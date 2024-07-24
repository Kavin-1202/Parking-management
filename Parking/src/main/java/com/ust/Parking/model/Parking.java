package com.ust.Parking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkingid;
    private String location;
    private int twoWheelerCapacity;
    private int fourWheelerCapacity;
    private int availableTwoWheelerSpots;
    private int availableFourWheelerSpots;

}
