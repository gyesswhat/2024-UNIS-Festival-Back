package com.example.liberewhaunis.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReviewResponseDto {
    private Integer reviewId;
    private String title;
    private String body;
    private String[] imageLinks;
    private Float rating;
    private String nickname;
}
