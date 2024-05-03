package com.example.liberewhaunis.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReservationRequestDto {
    private Integer date;
    private Integer time;
    private Integer menu1;
    private Integer menu2;
    private Integer menu3;
    private Integer menu4;
    private Integer menu5;
    private String customerName;
    private String customerPhone;
}
