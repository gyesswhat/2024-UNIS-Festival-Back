package com.example.liberewhaunis.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReviewListDto {
    private Integer reviewId;
    private String title;
    private String body;
    private String imageLinks;
    private Float rating;
    private String nickname;

    public String[] getImageLinksArray() {
        // ';' 구분자를 기준으로 문자열을 분할하여 배열로 반환
        return this.imageLinks != null ? this.imageLinks.split(";") : new String[0];
    }
}
