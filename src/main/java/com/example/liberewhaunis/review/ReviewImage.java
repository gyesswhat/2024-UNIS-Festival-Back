package com.example.liberewhaunis.review;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="review_image")
@Getter
@Setter
public class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewImageId;
    @Column
    private String imageLink;
    @ManyToOne
    @JoinColumn(name="reviewId")
    private Review review;
}
