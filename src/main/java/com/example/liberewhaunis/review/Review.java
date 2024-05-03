package com.example.liberewhaunis.review;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="review")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    @Column
    private String createdAt;
    @Column
    private String title;
    @Column
    private String body;
    @Column
    private Float rating;
    @Column
    private String nickname;
    @Column
    private String password;
}
