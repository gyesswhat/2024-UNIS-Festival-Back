package com.example.liberewhaunis.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthResponseDto {
    private String date;
    private String time;
    private Integer menu1;
    private Integer menu2;
    private Integer menu3;
    private Integer menu4;
    private Integer menu5;
    private String customerName;
    private String customerPhone;
}
