package com.example.liberewhaunis.auth;

import com.example.liberewhaunis.reservation.Reservation;
import com.example.liberewhaunis.reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {
    @Autowired
    ReservationRepository reservationRepository;

    public List<AuthResponseDto> showAuthReservations() {
        List<AuthResponseDto> authReservations = new ArrayList<>();
        List<Reservation> allReservations = reservationRepository.findAll();
        for (Reservation reservation : allReservations) {
            // 1. DTO 생성
            AuthResponseDto dto = new AuthResponseDto(
                    reservation.getDate() + 7 + "",
                    reservation.getTime().toString(),
                    reservation.getMenu1(),
                    reservation.getMenu2(),
                    reservation.getMenu3(),
                    reservation.getMenu4(),
                    reservation.getMenu5(),
                    reservation.getCustomerName(),
                    reservation.getCustomerPhone()
            );

            // 2. 시간대 문자열 변환
            if (dto.getTime().equals("1")) dto.setTime("아침(11:00)");
            else if (dto.getTime().equals("2")) dto.setTime("점심(12:30)");
            else if (dto.getTime().equals("3")) dto.setTime("간식(14:00)");
            else dto.setTime("저녁(17:00)");

            // 3. 리스트에 추가
            authReservations.add(dto);
        }
        return authReservations;
    }
}
