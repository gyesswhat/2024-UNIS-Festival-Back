package com.example.liberewhaunis.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReservationListDto {
    private Integer date;
    private Integer time;
    private String customerName;
}
