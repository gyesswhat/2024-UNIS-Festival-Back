package com.example.liberewhaunis.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BriefReviewResponseDto {
    private Integer reviewId;
    private String title;
    private String body;
    private Float rating;
}
