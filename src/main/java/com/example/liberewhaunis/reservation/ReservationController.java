package com.example.liberewhaunis.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<?> showReservations() {
        // 1. 예약 슬롯 리스트 만들기
        List<Integer> availabilityByTime = reservationService.getAvailability();
        // 2. 전체 예약 목록 리스트 만들기
        List<ReservationListDto> reservationList = reservationService.getReservations();
        // 3. 대답 담아서 보낼 responseDto 생성
        ReservationResponseDto reservationResponseDto = new ReservationResponseDto(availabilityByTime, reservationList);
        // 4. 응답
        return (reservationResponseDto != null)?
                ResponseEntity.status(HttpStatus.OK).body(reservationResponseDto):
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("예약 가능 여부 조회에 실패했습니다.");
    }

    @PostMapping("/reservations/add")
    public ResponseEntity<?> addReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        // 1. DTO -> Entity
        Reservation reservation = reservationService.addReservation(reservationRequestDto);
        // 2. 응답
        return (reservation != null)?
                ResponseEntity.status(HttpStatus.OK).build():
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("예약 요청에 실패했습니다.");
    }
}
