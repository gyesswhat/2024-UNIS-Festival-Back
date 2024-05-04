package com.example.liberewhaunis.review;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="review_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewImageId;
    @Column
    private String imageLink;
    @ManyToOne
    @JoinColumn(name="review_id")
    private Review review;
}
