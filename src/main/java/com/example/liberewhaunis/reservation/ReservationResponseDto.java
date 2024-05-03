package com.example.liberewhaunis.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ReservationResponseDto {
    private List<Integer> availabilityByTime;
    private List<ReservationListDto> reservationList;
}
