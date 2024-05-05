package com.example.liberewhaunis.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;

    @GetMapping("/auth")
    public ResponseEntity<?> showAuthReservations() {
        List<AuthResponseDto> authReservations = authService.showAuthReservations();
        return (authReservations != null)?
                ResponseEntity.status(HttpStatus.OK).body(authReservations):
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("아직 주문이 없습니다.");
    }
}
