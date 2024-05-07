package com.example.liberewhaunis.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDto {
    private String title;
    private String body;
    private Float rating;
    private String nickname;
    private String password;
    private String customerPhone;
}
