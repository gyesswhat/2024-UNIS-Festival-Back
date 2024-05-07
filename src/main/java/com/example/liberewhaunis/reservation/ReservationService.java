package com.example.liberewhaunis.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
    @Autowired ReservationRepository reservationRepository;
    LocalDateTime[][] compareTimes = {
            {
                    LocalDateTime.of(2024, 5, 8, 10, 30),
                    LocalDateTime.of(2024, 5, 8, 12, 00),
                    LocalDateTime.of(2024, 5, 8, 13, 30),
                    LocalDateTime.of(2024, 5, 8, 15, 30)
            },
            {
                    LocalDateTime.of(2024, 5, 9, 10, 30),
                    LocalDateTime.of(2024, 5, 9, 12, 00),
                    LocalDateTime.of(2024, 5, 9, 13, 30),
                    LocalDateTime.of(2024, 5, 9, 15, 30)
            },
            {
                    LocalDateTime.of(2024, 5, 10, 10, 30),
                    LocalDateTime.of(2024, 5, 10, 12, 00),
                    LocalDateTime.of(2024, 5, 10, 13, 30),
                    LocalDateTime.of(2024, 5, 10, 15, 30)
            }
    };

    // 사용 가능한 예약 슬롯 리턴
    public List<Integer> getAvailability() {
        // 1. 리턴할 리스트 생성
        List<Integer> availabilityByTime = new ArrayList<>();
        // 2. 현재 시간 가져오기
        LocalDateTime currentTime = LocalDateTime.now();
        // 3. 시간 + 예약 가능 여부로 비교
        for (int date=0; date<3; date++) {
            for (int time=0; time<4; time++) {
                if (currentTime.isBefore(compareTimes[date][time]) && reservationRepository.countReservations(date+1, time+1) < 10)
                    availabilityByTime.add(1);
                else
                    availabilityByTime.add(0);
            }
        }
        return availabilityByTime;
    }

    // 전체 예약 목록 리턴
    public List<ReservationListDto> getReservations() {
        List<ReservationListDto> reservationList = reservationRepository.findAllList();
        return reservationList;
    }

    // 새로운 예약 등록
    public Reservation addReservation(ReservationRequestDto reservationRequestDto) {
        // 1. 조건 검증
        if (reservationRequestDto.getTime()==null || reservationRequestDto.getDate()==null || reservationRequestDto.getCustomerPhone()==null || reservationRequestDto.getCustomerName()==null) return null;

        LocalDateTime currentTime = LocalDateTime.now();
        int date = reservationRequestDto.getDate() - 1;
        int time=4;
        if (reservationRequestDto.getTime().equals("AM 11:00")) time=0;
        else if (reservationRequestDto.getTime().equals("PM 12:30")) time=1;
        else if (reservationRequestDto.getTime().equals("PM 2:30")) time=2;
        else if (reservationRequestDto.getTime().equals("PM 4:00")) time=3;
        if (date>2 || date<0 || time==4) return null;
        if (currentTime.isBefore(compareTimes[date][time]) && reservationRepository.countReservations(date+1, time+1) < 10) {
            // 2. 엔티티 생성
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String createdAt = currentTime.format(formatter);
            Reservation reservation = new Reservation(
                    null,
                    createdAt,
                    reservationRequestDto.getDate(),
                    time+1,
                    reservationRequestDto.getCustomerName(),
                    reservationRequestDto.getCustomerPhone(),
                    reservationRequestDto.getMenu1(),
                    reservationRequestDto.getMenu2(),
                    reservationRequestDto.getMenu3(),
                    reservationRequestDto.getMenu4(),
                    reservationRequestDto.getMenu5()
            );
            reservationRepository.save(reservation);
            return reservation;
        }
        else {
            return null;
        }
    }
}
